# Der Inversion of Control Container (Spring IoC Container)

## Alles über den Spring Container

Inversion of Control ist auch bekannt als Dependency Injection. IoC oder DI ist ein Prozess wo Objekte ihr
Abhängigkeiten (dependencies) über einen Konstruktor Argument, ein Argument über eine Factory Methode oder Properties
definiert. Der Container injected dann diese Abhängigkeiten wenn er die Beans erstellt. Dieser Prozess ist im Grunde die
Umkehrung (daher der Name Inversion of Control) der Bean selbst, die die Instanziierung oder den Ort ihrer
Abhängigkeiten durch die direkte Konstruktion von Klassen oder einen Mechanismus wie das Service Locator Pattern
kontrolliert.

Die beiden Packages

* org.springframework.beans
* org.springframework.context

sind die Basis für den Container aus dem Spring Framework.

Das **BeanFactory** Interface ermöglicht einen fortgeschritttenen Konfigurationsmechanismus für das verwalten von
jeglichen Objekt Typen.

**ApplicationContext** ist ein Sub-Interface von **BeanFactory** und ist für folgende Features zuständig

* Einfachere Integration mit den Spring AOP Features
* Message resource handling (zur Verwendung bei der Internalisierung)
* Event publication
* Application-Layer spezifische Kontexte, wie z.B. der WebApplicationContext

Kurz gesagt, die BeanFactory stellt das Konfigurationsframework und die Basisfunktionalität bereit, und der
ApplicationContext fügt weitere unternehmensspezifische Funktionen hinzu.

### Container Übersicht

Das **org.springframework.context.ApplicationContext** Interface representiert den Spring IoC Container und ist
verantwortlich für die Instanzierung, Konfiguration und Zusammenstellung (assembling) der Beans. Der Container erhält
seine Instruktionen durch eine Metadata Konfiguration, welche in Form von

* XML (traditionelles Format)
* Java Annotation basierte Konfiguration (ab Spring 2.5)
* oder Java Code (ab Spring 3.0)

vorliegen kann. Der Spring IoC Container ist total entkoppelt von der Form der Metadata Konfiguration. Auch wenn aktuell
vor allem Java basierte Konfigurationen verwenden, sind alle 3 Formate gültig und können sogar innerhalb derselben
Applikation gemischt verwendet werden.

Mit Spring werden mehrere Implementierungen des ApplicationContext Interface geliefert. In eigenständigen Anwendungen
ist es üblich, eine Instanz von ClassPathXmlApplicationContext oder FileSystemXmlApplicationContext zu erstellen. In
einer WebApplikation wird der WebApplicationContext verwendet.

Eine Spring Konfiguration besteht aus mindestens einer Bean Definition welche der Container verwalten muss. XML basierte
Konfigurationen definieren diese Beans typischerweise in einem xml File als **</bean>** Element, welches im Top Level
Element **</beans>** enhalten sein muss. Üblicherweise werden keine Domänen Objekte (ddd) im Spring Container definiert,
es ist aber über [**AspectJ**](#TODO Link Angabe) möglich Objekte zu konfigurieren, welche ausserhalb der Kontrolle des
Containers erstellt wurden (#TODO Genauere Definition)

````xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
          https://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="..." class="...">
        <!-- collaborators and configuration for this bean go here -->
    </bean>
</bean>
<bean id="..." class="...">
<!-- collaborators and configuration for this bean go here -->
<!-- more bean definitions go here -->
</beans>
````

Das **id** Attribut ist ein String und definiert eine einzelne Bean Definition.

Das **class** Attribut definiert den Typ des Beans und verwendet den voll klassifizierten Klassennamen

### Das Erstellen eines Containers

Der Pfade, die einem ApplicationContext-Konstruktor übergeben werden, sind String, die es dem Container ermöglichen,
Konfigurationsmetadaten aus einer Vielzahl von externen Ressourcen zu laden, z. B. aus dem lokalen Dateisystem, dem Java
CLASSPATH usw.

````java
ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml","daos.xml");
````

Das folgende Beispiel zeigt ein Spring Bean Konfigurations-File (bean-config.xml):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
</beans>
```

#### Zusammenstellen von XML basierten Metadaten Konfigurationen

Es kann sinnvoll sein, verschieden XML Files für verschiedene logische Layer/Module in einem individuellen File zu
erstellen. Diese können dann in einer weiteren XML Konfiguration zusammengefasst werden.

````xml

<beans>
    <import resource="services.xml"/>
    <import resource="resources/dao.xml"/>
    <import resource="/resources/messageSource.xml"/>

    <bean id="springBean1" class="..."/>
    <bean id="springBean1" class="..."/>
</beans>
````

In obigem Beispiel werden externe Bean Defintionen aus 3 verschiedenen Files geladen: **services.xml**, **dao.xml**
und **messageSource.xml**.

Alle Pfadangaben sind relativ zur Definitionsdatei (obiges Beispiel). Die Datei services.xml muss sich also im selben
Verzeichnis oder Klassenpfad befinden wie die Datei, die den Import vornimmt. Während die Dateien messageSource.xml und
dao.xml in einem Ressourcenverzeichnis unterhalb der importierenden Datei liegen müssen. Ein **führender Slash** (/)
ignoriert. Da diese Pfade jedoch relativ sind, ist es besser, den **/** überhaupt nicht zu verwenden. Der Inhalt der
importierten Dateien, einschließlich des obersten <beans/>-Elements, muss gemäß dem Spring-Schema gültige
XML-Bean-Definitionen sein.

````text
Tip:  Mach das nicht!!!

Es ist möglich, aber nicht empfehlenswert, Dateien in übergeordneten Verzeichnissen mit einem relativen "../" Pfad zu referenzieren. 
Dadurch wird eine Abhängigkeit von einer Datei geschaffen, die sich außerhalb der aktuellen Anwendung befindet.

Ebenso kann man vollqualifizierte Resourcen (C:/config/services.xml) anstelle von relativen Pfaden angeben.
Falls es so etwas geben muss, dann arbeite mit "${...}" Platzhaltern, die zur Laufzeit gegen JVM-Systemeigenschaften aufgelöst werden.
````

#### Groovy Bean Definition DSL

Der vollständigkeithalber sei an dieser Stelle erwähnt, dass Spring auch eine Groovy DSL anbietet, über welche die
Konfigurationen gemacht werden kann. Diese Groovy DSL kommt aus dem Grails Framework (saugeil).

````groovy
   beans {
    dataSource(BasicDataSource) {
        driverClassName = "org.hsqldb.jdbcDriver"
        url = "jdbc:hsqldb:mem:grailsDB"
        username = "sa"
        password = ""
        settings = [mynew: "setting"]
    }
    sessionFactory(SessionFactory) {
        dataSource = dataSource
    }
    myService(MyService) {
        nestedBean = { AnotherBean bean ->
            dataSource = dataSource
        }
    }
}
````

### Den Container verwenden

Das ApplicationContext Interface bietet den Zugang zu allen registrierten, erstellten Beans und deren Abhängigkeiten (
Dependencies). Mit der Methode **T getBean(String name, Class<T> requiredType)** kann eine Instanz des Beans abgerufen
werden.

In der
Klasse [ClassPathXmlApplicationContextRunner.java](src/main/java/ch/wesr/spring/core/container/xml/ClassPathXmlApplicationContextRunner.java)
wird der Container in der Form des **ClassPathXmlApplicationContext** verwendet.

Im [bean-config.xml](src/main/resources/bean-config.xml) wird eine Bean konfiguriert.

```java
ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");

SpringBean springBean=context.getBean(SpringBean.class);
springBean.sayHello();
```

Der Code der Klasse [SpringBean](src/main/java/ch/wesr/spring/core/container/xml/beans/SpringBean.java) implementiert
die Methode **sayHello()**.

Das ApplicationContext Interface verfügt über einige andere Methoden zum Abrufen von Beans, aber im Idealfall sollte
dein Anwendungscode diese niemals verwenden. Eigentlich sollte der Applikationscodeüberhaupt keine Aufrufe der getBean()
-Methode enthalten und somit überhaupt nicht von Spring-APIs abhängig sein.

## Alles über Beans

Spring Beans werden über den Spring IoC Container verwaltet. Diese Beans werden mit den Metadata Configurations (z.B.
über die bean-config.xml) erstellt. Innerhalb des Containers werden diese Bean-Definitionen als BeanDefintion-Objekte
dargestellt, welche u.a. folgend Angaben besitzen

* Einen über eine package qualifizierter Klassennamen, meistens die tatsächliche Implementierungsklasse der zu
  definierenden Bean
* Ein Element, welches angibt, wie sich das Bean im Container verhalten soll (Scope, Lifecycle Callbacks, usw)
* Referenzen zu anderen Beans, welche benötigt werden. Diese Referenzen werden als Collaborators oder Dependencies
  bezeichnet.
* Andere Konfigurationseinstellungen, die in dem neue erstellen Objekt festgelegt werden soll

Da gibt es eine Tabelle welche diese Metadata Configuration in ein Set von Properties übersetzt, welche jeder Bean
Defintion ausmacht.

| Property                  | Explained in...         |
|--------------------------|--------------------------|
| Class                    | Instantiating Beans      |
| Name                     | Naming Beans             |
| Scope                    | Bean Scopes              |
| Constructor arguments    | Dependency Injection     |
| Properties               | Dependency Injection     |
| Autowiring mode          | Autowiring Collaborators |
| Lazy initialization mode | Lazy-initialized Beans   |
| Initialization method    | Initialization Callbacks |
| Destruction method       | Destruction Callbacks    |

````text
TODO Ein Beispiel wie ein ausserhalb des Container erstelltes Objekt registriert wird.
````

Zusätzlich zu den Bean-Definitionen, die Informationen darüber enthalten, wie eine bestimmte Bean zu erstellen ist,
erlauben die ApplicationContext-Implementierungen auch die Registrierung bestehender Objekte, die außerhalb des
Containers (von Benutzern) erstellt werden. Dies geschieht durch den Zugriff auf die BeanFactory des ApplicationContext
über die Methode getBeanFactory(), die die Implementierung der BeanFactory DefaultListableBeanFactory zurückgibt.
DefaultListableBeanFactory unterstützt diese Registrierung durch die Methoden registerSingleton(..) und
registerBeanDefinition(..). Typische Anwendungen arbeiten jedoch ausschließlich mit Beans, die durch reguläre
Bean-Definitions-Metadaten definiert sind.

Bean-Metadaten und manuell bereitgestellte Singleton-Instanzen müssen so früh wie möglich registriert werden, damit der
Container sie während des Autowiring und anderer Introspektionsschritte richtig interpretieren kann. Während das
Überschreiben vorhandener Metadaten und vorhandener Singleton-Instanzen bis zu einem gewissen Grad unterstützt wird,
wird die Registrierung neuer Beans zur Laufzeit (gleichzeitig mit dem Live-Zugriff auf die Factory)
nicht offiziell unterstützt und kann zu Ausnahmen bei gleichzeitigem Zugriff, zu einem inkonsistenten Zustand im
Bean-Container oder zu beidem führen.

ok, bis hierhin ist es eigentlich keine Zusammenfassung sondern eine Übersetzung

### Beans benennen

Jedes Bean hat einen unique identifier - ob er über das Attribute **id** angegeben wird oder nicht.

Beim Scannen von Komponenten im Klassenpfad generiert Spring Bean-Namen für unbenannte Komponenten und folgt den Regeln:

* Im Wesentlichen wird der einfache Klassenname genommen und sein erstes Zeichen in einen Kleinbuchstaben umgewandelt.
* In dem (ungewöhnlichen) Sonderfall, dass es mehr als ein Zeichen gibt und sowohl das erste als auch das zweite Zeichen
  Großbuchstaben sind, wird die ursprüngliche Schreibweise beibehalten.
* Dies sind die gleichen Regeln, wie sie in java.beans.Introspector.decapitalize definiert sind (die Spring hier
  verwendet).

Bean Konfiguration mit einer eindeutigen Id und 2 Aliases, separiert durch ein Komma und zugehörigen validen Aufrufen im
Code

````xml
<bean id="springBean" name="customBean, dedicatedBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
````

````java
SpringBean springBean=context.getBean(SpringBean.class);
// oder
SpringBean springBean=(SpringBean)context.getBean("springBean");
// oder
SpringBean springBean1=(SpringBean)context.getBean("customBean");
// oder
SpringBean springBean2=(SpringBean)context.getBean("dedicatedBean");
````

Bean Konfiguration ohne definierte id oder name Attribut

````xml
<bean class="ch.wesr.spring.core.container.xml.beans.SpringBean2"/>
````

````java
SpringBean2 springBean2=context.getBean(SpringBean2.class);
````

Bean Konfiguration mit Sonderzeichen: Wenn auch üblich oder konventionell ist, dass die Namen der Attributte **
alphanumerisch**, meistens mit einem **Kleinbuchstaben** und in **CamelCase** ('sprinBean', 'myBean') geschrieben sind,
können die Attribute _id_ und _name_ auch **Sonderzeichen** enthalten sowie mit **,** oder **;** unterteilt werden.

````xml

<bean id="$$*ç%" class="ch.wesr.spring.core.container.xml.beans.SpringBean3"/>
````

````java
SpringBean3 springBean2=context.getBean("spring-Bean$3");
````

Bean Konfiguration ohne _id_ Attribut, kann über eines der Aliase aufgerufen werden, auch wenn dieses Sonderzeichen
enthält.

````xml
<bean name="schnullifax;%ç*$$" class="ch.wesr.spring.core.container.xml.beans.SpringBean5"/>
````

````java
SpringBean5 springBean5=(SpringBean5)context.getBean("%ç*$$");
````

**Warum gibt es die Möglichkeit einem Bean Aliases zu definieren?**

In einer Bean-Definition selbst kann man mehr als einen Namen für die Bean angeben. Dies geschieht mit einer Kombination
aus einem **id** Attribut und einer beliebigen Anzahl **Aliases**. Diese Namen können äquivalente Aliase für dieselbe
Bean sein und sind in einigen Situationen nützlich, wie z.B. wenn jede Komponente in einer Anwendung auf eine gemeinsame
Abhängigkeit verweisen soll, indem ein Bean-Name verwendet wird, der spezifisch für diese Komponente selbst ist.

##### Aliasing a Bean outside the Bean Definition

Die Angabe aller Aliase an den Stellen, an denen die Bean tatsächlich definiert ist, ist jedoch nicht immer ausreichend.
Manchmal ist es wünschenswert, einen Alias für eine Bean einzuführen, die an anderer Stelle definiert ist. Dies ist
häufig in großen Systemen der Fall, in denen die Konfiguration auf die einzelnen Subsysteme aufgeteilt ist, wobei jedes
Subsystem seinen eigenen Satz von Objektdefinitionen hat.

````xml

<alias name="customBean1" alias="subsystemA-customBean1"/>
<alias name="customBean1" alias="subsystemB-customBean1"/>
````

```java
SpringBean1 subsystemACustomBean1=(SpringBean1)context.getBean("subsystemA-customBean1");
subsystemACustomBean1.sayHelloFrom();

SpringBean1 subsystemBCustomBean1=(SpringBean1)context.getBean("subsystemB-customBean1");
subsystemBCustomBean1.sayHelloFrom();
```

Wichtig dabei ist zu wissen, dass sich trotzdem immer um dasselbe Bean handelt. Darum wird dieser Mechanismus oftmals
bei Datsourcen verwendet, bei welchem ein Bean die Datenbankverbindung erstellt und in verschiedenen Sub-Modulen einer
Applikation verwendet wird.

```text
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean1: ch.wesr.spring.core.container.xml.beans.SpringBean1@62fdb4a6
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean1: ch.wesr.spring.core.container.xml.beans.SpringBean1@62fdb4a6
```

Das gesamte Code Beispiele findest du in der
Klasse [ClassPathXmlApplicationContextRunner.java](src/main/java/ch/wesr/spring/core/container/xml/ClassPathXmlApplicationContextRunner.java)

### Beans instanzieren

Eine Bean Definition erzeugt eines oder mehrere Objekte. In XML-basierten Konfigurationsmetadaten, gibt man den Typ (
oder die Klasse) des Objekts, das instanziiert werden soll, im **class** Attribut des **<bean/>** Elements an. Dieses **
class** Attribut (das intern eine Class-Eigenschaft einer BeanDefinition-Instanz ist) ist normalerweise obligatorisch.
Nur wenn man eine Factory Bean Methode verwendet ist dieses class Attribut hinfällig.

Es gibt 2 verschiedene Arten wie man ein Bean instanzieren kann.

**Wenn der Konstruktor reflektiv durch den Container aufgerufen wird.**

````xml
<bean id="springBean" name="customBean, dedicatedBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
````

````java
ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");

SpringBean springBean=context.getBean(SpringBean.class);
````

Code unter: [InstantiatingBeanRunner.java](src/main/java/ch/wesr/spring/core/container/xml/InstantiatingBeanRunner.java)

**Wenn die zu instanzierende Klasse eine static Factory Method besitzt.**

```xml

<bean id="springBeanService"
      class="ch.wesr.spring.core.container.xml.beans.SpringBeanService"
      factory-method="erstelleSpringBeanService"/>
```

````java
ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");
SpringBeanService springBeanService=context.getBean(SpringBeanService.class);
springBeanService.sayHello();
````

**Wenn es eine Factory Bean Methode gibt**

Zuerst muss man natürlich die Factory Bean konfigurieren.

**Achtung:** Dieses Factory Bean bezieht sich auf ein Bean, welches im Container konfiguriert und über den Konstruktor
oder eine statische factor method erzeugt wurde. Im Kontrast zu einem **FactoryBean**, welches eine **Spring-spezfische
Implementierungsklasse** ist.

````xml

<bean id="serviceLocator" class="ch.wesr.spring.core.container.xml.beans.DefaultServiceLocator"/>
````

Danach kann in der Konfiguration das **class** Attribut weggelassen werden. Zudem ist es auch möglich in einer Factory
Bean mehrere Instanzen von verschiedenen Objekten zu erzeugen.

```xml

<bean id="springBeanServiceByLocator"
      factory-bean="serviceLocator"
      factory-method="erstelleSpringBeanService"/>

<bean id="clientServiceByLocator"
      factory-bean="serviceLocator"
      factory-method="erstelleClientService"/>
```

````java
SpringBeanService1 springBeanService1=context.getBean(SpringBeanService1.class);
springBeanService1.sayHello();

ClientService clientService=context.getBean(ClientService.class);
clientService.sayHello();
````

**Wie kann ich den Typ einer Bean herausfinden?**

Der empfohlene Weg, um den tatsächlichen Laufzeittyp einer bestimmten Bean herauszufinden, ist ein
BeanFactory.getType-Aufruf für den angegebenen Bean-Namen. Dabei werden alle oben genannten Fälle berücksichtigt und der
Objekttyp zurückgegeben, den ein BeanFactory.getBean-Aufruf für denselben Bean-Namen zurückgeben wird.

Wie schon einmal erwähnt ist das **ApplicationContext**  ein Sub-Interface von **BeanFactory**

````java
String clientServiceByLocator=context.getType("clientServiceByLocator").getName();
assert clientServiceByLocator.equals("ch.wesr.spring.core.container.xml.beans.ClientService");
System.out.println("Type of bean: "+clientServiceByLocator);
// oder
Class<?> clientServiceByLocator1=context.getType("clientServiceByLocator");
assert Objects.requireNonNull(clientServiceByLocator1).isInstance(ClientService.class);
````

Das gesamte Code Beispiel findest du in der
Klasse [InstanceFactoryBeanRunner.java](src/main/java/ch/wesr/spring/core/container/xml/InstanceFactoryBeanRunner.java)

## Dependency Injection

* Constructor-based
* Setter-based

### Constructor-based

#### [Constructor argument resolution](doc/dependencies/di/constructor_argument_resolution.md)

#### [Constructor argument type matching](doc/dependencies/di/constructor_argument_type_matching.md)

#### [Constructor argument index](doc/dependencies/di/constructor_argument_index.md)

**TODO @ConstructorProperties Beispiel**

````java
public class ExampleBean {
    // Fields omitted
    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
````

### Setter based

### [Setter based ohne Argumente](doc/dependencies/di/setter_based_ohne_argumente.md)

### Constructor oder Setter based Dependency Injection

Obwohl es möglich ist constructor-based und setter-based Dependency Injection zu kombinieren/mischen ist es ein gute
Gewohnheit constructor-based DI für zwingende Abhängigkeiten zu verwenden. Während dem die setter-based Variante eher
für optional DI verwendet wird.

Die **Constructor-based** Varianten (ohne Argumente) lässt Komponenten/Beans als immutable Objects verwenden und werden
immer zum Caller zurückgegeben. Diese Variante mit (zu vielen) Argumenten zu verwenden, lässt nicht nur die Immutability
verschwinden sondern ist auch eine schlechte Code Variante. Besonders bei (third-party) Klassen, von welchen man den
Source Code nicht besitzt ist die constructor-based Variante ohne Argumente von Vorteil.

### [Setter based für optionale Abhängigkeiten](doc/dependencies/di/setter_based_optional.md)

### Der Dependency Resolution (Auflösung) Process
Der Container (ApplicationContext) löst die Bean Abhängigkeiten folgendermassen aus.

* Der ApplicationContext wird erstellt und initalisiert alle Beans über die Metadata-Konfiguration (xml, Java Code oder Annotations).
* Beim Erstellen einer Bean werden die Abhängigkeiten übergeben und definiert über eine der folgenden Möglichkeiten. 
  * Properties **\<property name="springBean" ref="springBean"/>**
  * Constructor Argumente  **<constructor-arg ref="springBean"/>**
  * static Factory **<bean id="springBeanService" class="ch.wesr.spring.core.container.xml.beans.SpringBeanService "factory-method="erstelleSpringBeanService"/>**
* Jedes Property oder Constructor Argument ist eine Defintion eines Wertes oder eine Referenz zu eine anderen Bean der/die gesetzt werden muss
* Jedes Property oder  Constructor Argument, das ein Wert ist, wird von seinem angegebenen Format in den tatsächlichen Typ dieser Eigenschaft oder dieses Konstruktorarguments konvertiert. 
  Standardmäßig kann Spring einen Wert, der im String-Format übergeben wird, in alle eingebauten Typen konvertieren, wie int, long, String, boolean und so weiter.

Beim Erstellen des Spring Container wird jede Konfiguration einer Bean geprüft. Die Bean Properties werden aber erst beim Erstellen der Bean effektiv gesetzt.
Dies gilt es zu beachten obwohl der Default Zustand einer Bean ein Singleton-Scope ist und diese Singleton Beans ebenfalls beim Erstellen des Containers erzeugt werden.

Ansonsten gilt, das Bean wird erst erzeugt, wenn es angefordert (requested) wird und eben dann, beim Erstellen der Bean, werden die Properties gesetzt.
Die Erstellung einer Bean führt potenziell zur Erstellung eines Graphen von Beans, da die Abhängigkeiten der Bean und die Abhängigkeiten ihrer Abhängigkeiten (und so weiter) erstellt und zugewiesen werden. 
Achtung: Fehler beim Auflösen solcher Abhängigkeiten können erst spät auftauchen, nämlkich dann wenn die betroffenen Beans erstellt werden.

### Circular Dependencies
Bei überwiegend verwendeten Constructor-based DI kann es sein, dass man sich unauflösbare, zirkuläre Abhängigkeiten schafft.

Zum Beispiel: Klasse A benötigt eine Instanz von Klasse B durch Konstruktorinjektion, und Klasse B benötigt eine Instanz von Klasse A durch Konstruktorinjektion. Wenn Sie Beans für die Klassen A und B so konfigurieren, dass sie ineinander injiziert werden, erkennt der Spring IoC-Container diese zirkuläre Referenz zur Laufzeit und löst eine BeanCurrentlyInCreationException aus.
Eine mögliche Lösung besteht darin, den Quellcode einiger Klassen so zu bearbeiten, dass sie über Setter und nicht über Konstruktoren konfiguriert werden. Alternativ dazu kann man die Konstruktorinjektion vermeiden und nur die Setterinjektion verwenden. Mit anderen Worten, obwohl es nicht empfohlen wird, können Sie zirkuläre Abhängigkeiten mit Setter-Injection konfigurieren.
Im Gegensatz zum typischen Fall (ohne zirkuläre Abhängigkeiten) zwingt eine zirkuläre Abhängigkeit zwischen Bean A und Bean B dazu, dass eine der Beans in die andere injiziert wird, bevor sie selbst vollständig initialisiert ist (ein klassisches Huhn-und-Ei-Szenario).


### Dependencies and Configuration
Bean-Eigenschaften und Konstruktorargumente können als Referenzen auf andere verwaltete Beans (Collaborators) oder als inline definierte Werte definiert werden. 
Die XML-basierten Konfigurationsmetadaten von Spring unterstützen zu diesem Zweck Unterelementtypen innerhalb ihrer \<property/>- und \<constructor-arg/>-Elemente.

#### [Straight Values (Primitives, Strings)](doc/dependencies/configurations/straight_values.md)
Das *value* Attribut im \<property/> Element definiert ein Property oder ein Konstruktor Argument als einen lesbaren String.
Der Spring *conversion service* konvertiert dann diese Werte aus einem String in den effektiv verwendeten Typ.

#### [Verwendung des p-namespace aus dem Spring Schema]()
Wenn man den **p-namespace** für kürzere XML Konfigurationen verwendet geht die Bean Configuration noch einfacher

**TODO java.util.Properties verwenden?**
Siehe Beispiel: [property-source-placeholder.xml](src/main/resources/property-source-placeholder.xml)

Das Code Beispiel erstellt - habe ich aber noch nicht verstanden und funktioniert deshalb noch nicht.
Code Beispiel [SimplePropertiesDataSource.java](src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/SimplePropertiesDataSource.java)

#### [Das idref Element](doc/dependencies/configurations/idref.md)
Das *idref* Element wird verwendet um die Id eines Beans einem anderen Bean als String zur Verfügung zu stellen.
Die Verwendung des *idref* Tag ermöglicht dem Container zum Zeitpunkt der Erstellung zu überprüfen ob die referenzierte Bean tatsächlich existiert.

### Referenezen zu anderen Beans (Collaborators)

#### [Das ref Element](doc/dependencies/configurations/ref.md)
Das *ref* Element wird als letztes (finales) Element innerhalb von \<property/> oder \<constructor-arg/> verwendet.
Kann auch im parent-child Kontext verwendet werden.

#### [Das ref Element zu einem parent](doc/dependencies/configurations/ref_mit_parent.md)
**TODO ref mit parent** 

Obwohl das parent ref Beispiel an dieser Stelle in der Spring Doku erwähnt wird, habe ich keinen Plan wie das umgesetzt wirde.

#### [Inner Beans](doc/dependencies/configurations/inner_beans.md)
Inner Beans werden als \<bean/> Element innerhalb der \</property/> oder \<constructor-arg/> Elemente einer Outer Bean definiert.


## to be completed

