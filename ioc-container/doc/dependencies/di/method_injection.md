# Spring Method Injection Beispiel

In den meisten Anwendungsszenarien sind die meisten Beans im Container Singletons.
Wenn eine Singleton-Bean mit einer anderen SingletonBean oder eine Nicht Singleton-Bean mit einer anderen Nicht SingletonBean zusammenarbeiten muss,
wird die Abhängigkeit normalerweise über eine Eigenschaft der anderen Bean definiert.


* **Singleton**: Nur ein Objekt instanziieren
* **Prototyp**: Jedes Mal ein neues Objekt instanziieren.


## Das Problem: setter-based Injection für PrototypeBeans
Ein Problem ergibt sich, wenn die Lebenszyklen der Beans unterschiedlich sind.
Angenommen, die Singleton-Bean A muss die Nicht-Singleton-Bean (Prototyp) B verwenden, vielleicht bei jedem Methodenaufruf von A.
Der Container erstellt die Singleton-Bean A nur einmal und hat daher nur einmal die Möglichkeit, die Eigenschaften zu setzen.
Der Container kann Bean A nicht jedes Mal eine neue Instanz von Bean B zur Verfügung stellen, wenn eine benötigt wird.

### [setter-base-injection.xml](../../../src/main/resources/dependencies/methodinjection/setter-base-injection.xml)
```xml
<bean id="prototypeBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.PrototypeBean" scope="prototype">
    <property name="message" value="Test Message" />
</bean>

<bean id="singletonBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.SingletonBean" >
    <property name="prototypeBean" ref="prototypeBean"/>
</bean>
```
### [PrototypeBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/PrototypeBean.java)
Die PrototypeBean ist eine ganz normale, einfache Klasse.
````java
public class PrototypeBean {
    private String message;

    public PrototypeBean() {
        System.out.println("Prototype Bean Instantiated !!");
    }

    public void sayHello(String variableName) {
        System.out.println("Ich bin das Bean: " +variableName);
        System.out.println("\tobject: " +this);
        System.out.println("\tmessage: " +this.getMessage());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
````

### [SingletonBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/SingletonBean.java)
Die SingletonBean hat das PropertyBean als Eigenschaft/Property und wird über eine setter-Methode gesetzt.
````java
public class SingletonBean {
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        System.out.println("Singleton Bean Instantiated !!");
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }

    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
````

### [AlwaysTheSamePrototypeBeanRunner](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/AlwaysTheSamePrototypeBeanRunner.java)
In der AlwaysTheSamePrototypeBeanRunner Klasse wird die PrototypeBean 2x instanziert - in der Hoffnung auch 2 Instanzen zu bekommen.
````java
System.out.println("Beschreibung: Setter based injection -> es wird immer dasselbe PrototypeBean zurückgegeben");
ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/methodinjection/setter-base-injection.xml");
SingletonBean singleton = (SingletonBean)context.getBean("singletonBean");
PrototypeBean prototypeBeanA = singleton.getPrototypeBean();
PrototypeBean prototypeBeanB = singleton.getPrototypeBean();

prototypeBeanA.sayHello("prototypeBeanA");
prototypeBeanB.sayHello("prototypeBeanB");
System.out.println("Ist da  prototypeBeanA und prototypeBeanA  dasselbe ? " + (prototypeBeanA==prototypeBeanB));
````

### output
Aus dem output erkennt man, dass die beiden vermeintlich 2x instanzierten PropertyBeans immer dieselbe Instanz zurückbekommen.
````text
Beschreibung: Setter based injection -> es wird immer dasselbe PrototypeBean zurückgegeben
Singleton Bean Instantiated !!
Prototype Bean Instantiated !!
Ich bin das Bean: prototypeBeanA
	object: ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.PrototypeBean@6b419da
	message: Test Message
Ich bin das Bean: prototypeBeanB
	object: ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.PrototypeBean@6b419da
	message: Test Message
Ist da  prototypeBeanA und prototypeBeanA  dasselbe ? true
````

## Die Lösung: Lookup Method injection

Eine Lösung besteht darin, auf eine *Inversion of control* zu verzichten. 
Dabei wird die Bean A dem Container bekannt gemacht, indem man die Schnittstelle ApplicationContextAware implementiert.
Jedes Mal, wenn Bean A eine (typischerweise neue) Bean B-Instanz benötigt, 
wird einen getBean("B")-Aufruf an den Container gerichtet.
Bei der Methodeninjektion werden Abhängigkeiten mit Hilfe von Methoden-Lookups aufgelöst, 
bei denen eine bestimmte Methode einer bestimmten Bean aufgerufen wird, um die Bean-Instanz zu erhalten.

### Warum Lookup Method verwenden?
Method Injection sollte verwendet werden, wenn eine SingletonBean eine Abhängigkeit zu einer PrototypeBean hat und diese PrototypeBean bei jedem Aufruf
eine unterschiedliche Instanz hervorbringen soll.


#### [method-injection.xml](../../../src/main/resources/dependencies/methodinjection/method-injection.xml)
In der xml Konfiguration erkennt man sofort, dass es ein Bean Definition **AbstractSingletonBean** gibt, welche ein
Element 

**\<lookup-method bean="prototypeBean" name="getPrototypeBean"/>** 

enhält. Dabei wird das Attribut *bean* mit der Bean ID des PrototypeBean und der *name* mit der getter Methode der PrototyepBean definiert.

```xml
<bean id="prototypeBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.PrototypeBean" scope="prototype">
    <property name="message" value="Test Message"/>
</bean>

<bean id="abstractSingletonBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.AbstractSingletonBean">
    <lookup-method bean="prototypeBean" name="getPrototypeBean"/>
</bean>
```
Dabei verändert sich die [PrototypeBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/PrototypeBean.java) gegenüber dem
vorherigen Beispiel nichh.

#### [AbstractSingletonBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/AbstractSingletonBean.java)
Allerdings wird zum Unterschied des obigen Beispiels die SingletonBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/SingletonBean.java)
in eine abstracte Klasse AbstractSingletonBean überführt.
In dieser abstrakten Klasse gibt es eine abstracte Methode definiert, welche ein ProtototypeBean Objekt zurück gibt.
````java
abstract class AbstractSingletonBean {

    public AbstractSingletonBean() {
        System.out.println("Abstract Singleton Bean instantiated !!");
    }

    public abstract PrototypeBean getPrototypeBean();
}
````

#### [AlwaysTheSamePrototypeBeanRunner](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/methodinjection/AlwaysTheSamePrototypeBeanRunner.java)
Wiederum werden 2 PrototypeBean instanziert 
````java
System.out.println("Beschreibung: method injection > es wird immer eine Methode im PrototypeBean gesucht, instanziert und diese zurückgegeben");
ApplicationContext contextMethodInjection = new ClassPathXmlApplicationContext("dependencies/methodinjection/method-injection.xml");
AbstractSingletonBean abstractSingletonBean = (AbstractSingletonBean)contextMethodInjection.getBean("abstractSingletonBean");
PrototypeBean injectedPrototypeBeanA = abstractSingletonBean.getPrototypeBean();
PrototypeBean injectedPrototypeBeanB = abstractSingletonBean.getPrototypeBean();

injectedPrototypeBeanA.sayHello("injectedPrototypeBeanA");
injectedPrototypeBeanB.sayHello("injectedPrototypeBeanB");
System.out.println("Ist da  prototypeBeanA und prototypeBeanA  dasselbe ? " + (injectedPrototypeBeanA==injectedPrototypeBeanB));
````
mit dem Resultat, dass jetzt 2 unterschiedlichen Instanzen des PrototypeBeans erzeugt wird.
#### output
````text
Beschreibung: method injection > es wird immer eine Methode im PrototypeBean gesucht, instanziert und diese zurückgegeben
Abstract Singleton Bean instantiated !!
Prototype Bean Instantiated !!
Prototype Bean Instantiated !!
Ich bin das Bean: injectedPrototypeBeanA
	object: ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.PrototypeBean@7e07db1f
	message: Test Message
Ich bin das Bean: injectedPrototypeBeanB
	object: ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection.PrototypeBean@1189dd52
	message: Test Message
Ist da  prototypeBeanA und prototypeBeanA  dasselbe ? false
````


## Referenzen
* [Blog über die Motivation Method Injection einzusetzen](https://spring.io/blog/2004/08/06/method-injection/)
* [http://www.wideskills.com/spring/method-injection-in-spring](http://www.wideskills.com/spring/method-injection-in-spring)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
