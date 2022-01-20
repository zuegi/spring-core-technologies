# Spring <template> Beispiel

In Spring gibt es 2 Möglichkeiten Beans zu injecten - manuell oder autowired.


### Manuelle Verdrahtung über das **ref** Attribut im \<property/> Element
[ref.xml](../../../src/main/resources/dependencies/autowire/ref.xml)
```xml
<bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="autowireBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.autowire.AutowireBean">
    <property name="springBean">
        <ref bean="springBean"/>
    </property>
</bean>
```
Unter Verwendung derselben **AutowireBean** - einfach über eine andere xml Konfiguration 
### [SimpleRefBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/autowire/SimpleRefBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/ref.xml");
AutowireBean bean = context.getBean(AutowireBean.class);

bean.sayHello();
````
### output
````text
Hello from AutowireBean
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
````

### Automatische Verdrahtung über das **autowire** Attribut im \<bean/> Element
Es gibt 4 verschiedene Optionen/Möglichkeiten für Autowiring
* **autowire="byName"** : Autowiring anhand des Eigenschaftsnamens. Wenn eine Bean mit demselben Namen wie die Eigenschaft einer anderen Bean gefunden wird, wird diese Bean mit der Eigenschaft der anderen Bean verdrahtet
* **autowire="byType"** : Wenn eine Bean mit demselben Typ wie die Eigenschaft einer anderen Bean gefunden wird, wird diese Bean mit der Eigenschaft einer anderen Bean verbunden
* **autowire="constructor"** : Wenn eine Bean mit dem gleichen Typ wie das Konstruktor-Argument einer anderen Bean gefunden wird, wird diese Bean mit dem Konstruktor der anderen Bean verbunden
* **autowire="no"** : Kein Autowiring. Dasselbe wie die explizite Angabe einer Bean mit dem Attribut "ref".

#### autowire="byName"
In diesem Beispiel wird dem AutowiredBean das Attribute **autowire="byName"** gesetzt.
Was zur Folge hat, dass die SpringBean welche Feld in der AutowireBean gesetzt wird automatisch verdrahtet/injected wird.

[autowire-by-name.xml](../../../src/main/resources/dependencies/autowire/autowire-by-name.xml)
````xml
<bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="autowireBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.autowire.AutowireBean" autowire="byName"/>
````

### [AutowireBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/autowire/AutowireBean.java)
````java
public class AutowireBean {

    private SpringBean springBean;

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
        springBean.sayHello();
    }

    public SpringBean getSpringBean() {
        return springBean;
    }

    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }
}
````

### [SimpleAutowireBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/autowire/SimpleAutowireBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/autowire.xml");
AutowireBean bean = context.getBean(AutowireBean.class);

bean.sayHello();
````

#### output
````text
Hello from AutowireBean
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
````

### [autowire-by-type.xml](../../../src/main/resources/dependencies/autowire/autowire-by-type.xml)
````xml
<bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="autowireBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.autowire.AutowireBean" autowire="byName"/>
````

### [SimpleAutowireBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/autowire/SimpleAutowireBeanRunner.java)
````java
ApplicationContext contextByType = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-by-type.xml");
AutowireBean beanByType = contextByType.getBean(AutowireBean.class);
$
        beanByType.sayHello();
````
### [autowire-constructor.xml](../../../src/main/resources/dependencies/autowire/autowire-constructor.xml)
````xml
<bean class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="autowireBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.autowire.AutowireConstructorBean" autowire="constructor"/>
````

### [SimpleAutowireBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/autowire/SimpleAutowireBeanRunner.java)
```java
ApplicationContext contextConstructor = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-constructor.xml");
AutowireConstructorBean autowireConstructorBean = contextConstructor.getBean(AutowireConstructorBean.class);

autowireConstructorBean.sayHello();
```

### [autowire-no.xml](src/main/resources/dependencies/autowire/autowire-no.xml)
In diesem Beispiel ist das **autowire="no"** (was dem default entspricht) und deshalb muss das _springBean_ über das **ref** Attribut im \<property/> Element injected/verdrahtet werden.
````xml
 <bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="autowireBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.autowire.AutowireBean" autowire="no">
    <property name="springBean">
        <ref bean="springBean"/>
    </property>
</bean>
````


### Einschränkungen und Nachteile von Autowiring
Autowiring funktioniert am besten, wenn es in einem Projekt konsistent eingesetzt wird. Wenn Autowiring nicht allgemein verwendet wird, kann es für Entwickler verwirrend sein, wenn nur ein oder zwei Bean-Definitionen damit verdrahtet werden.
Beachte die Einschränkungen und Nachteile von Autowiring:
- Explizite Abhängigkeiten in **property** und **constructor-arg** Settings haben immer Vorrang vor Autowiring. 
Einfache Properties wie *primitives*, *Strings* und *Classes* (und Arrays solcher einfacher Eigenschaften) nicht automatisch verdrahten. 
Diese Einschränkung ist gewollt. 


- Autowiring ist weniger genau als explizite Verdrahtung. Wie bereits in der vorangegangenen Tabelle erwähnt, achtet Spring jedoch darauf, 
im Falle von Mehrdeutigkeiten, die zu unerwarteten Ergebnissen führen könnten, keine Vermutungen anzustellen. 
Die Beziehungen zwischen Ihren von Spring verwalteten Objekten sind nicht mehr explizit dokumentiert.


- Verdrahtungsinformationen sind möglicherweise für Tools, die Dokumentation aus einem Spring-Container generieren, nicht verfügbar.
 

- Mehrere Bean-Definitionen innerhalb des Containers können mit dem Typ übereinstimmen, der von der Setter-Methode oder dem Konstruktor-Argument angegeben wird, um automatisch verdrahtet zu werden. Für Arrays, Collections oder Map-Instanzen ist dies nicht unbedingt ein Problem. Bei Abhängigkeiten, die einen einzelnen Wert erwarten, wird diese Mehrdeutigkeit jedoch nicht willkürlich aufgelöst. Wenn keine eindeutige Bean-Definition verfügbar ist, wird eine Ausnahme geworfen.

### Beans für das Autowiring ausschliessen
Sie können eine Bean pro Bean vom Autowiring ausschließen. 
Im XML-Format von Spring setzen Sie das Attribut autowire-candidate des \<bean/>-Elements auf **false**. 
Der Container macht diese spezifische Bean-Definition für die Autowiring-Infrastruktur (einschließlich Konfigurationen im Annotationsstil wie @Autowired) nicht verfügbar.


Ausdeutschen

Sie können Autowire-Kandidaten auch auf der Grundlage von Mustervergleichen mit Bean-Namen einschränken. Das <beans/>-Element der obersten Ebene akzeptiert ein oder mehrere Muster in seinem Attribut default-autowire-candidates. Um beispielsweise den Autowire-Kandidatenstatus auf alle Beans zu beschränken, deren Name mit Repository endet, geben Sie den Wert *Repository an. Um mehrere Muster anzugeben, definieren Sie diese in einer durch Komma getrennten Liste. Ein expliziter Wert von true oder false für das Attribut "autowire-candidate" einer Bean-Definition
42

hat immer Vorrang. Für solche Beans gelten die Mustervergleichsregeln nicht.
Diese Techniken sind nützlich für Beans, die niemals durch Autowiring in andere Beans injiziert werden sollen. Das bedeutet nicht, dass eine ausgeschlossene Bean nicht selbst mit Hilfe von Autowiring konfiguriert werden kann. Vielmehr ist die Bean selbst kein Kandidat für das Autowiring anderer Beans.


## Resourcen
[spring beans autowiring xml](http://websystique.com/spring/spring-beans-auto-wiring-example-using-xml-configuration/)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
