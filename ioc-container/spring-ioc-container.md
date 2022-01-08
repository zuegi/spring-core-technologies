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
Das ApplicationContext Interface bietet den Zugang zu allen registrierten, erstellten Beans und deren Abhängigkeiten (Dependencies).
Mit der Methode **T getBean(String name, Class<T> requiredType)** kann eine Instanz des Beans abgerufen werden.

In der Klasse [ClassPathXmlApplicationContextRunner.java](./src/main/java/ch/wesr/spring/core/container/xml/ClassPathXmlApplicationContextRunner.java)
wird der Container in der Form des **ClassPathXmlApplicationContext** verwendet.

Im [bean-config.xml](./src/main/resources/bean-config.xml) wird eine Bean konfiguriert.
```java
    ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

    SpringBean springBean = context.getBean(SpringBean.class);
    springBean.sayHello();
```
Der Code der Klasse [SpringBean](./src/main/java/ch/wesr/spring/core/container/xml/beans/SpringBean.java) implementiert die Methode **sayHello()**.

Das ApplicationContext Interface verfügt über einige andere Methoden zum Abrufen von Beans, aber im Idealfall sollte dein Anwendungscode diese niemals verwenden. 
Eigentlich sollte der Applikationscodeüberhaupt keine Aufrufe der getBean()-Methode enthalten und somit überhaupt nicht von Spring-APIs abhängig sein. 


## Alles über Beans
Spring Beans werden über den Spring IoC Container verwaltet. Diese Beans werden mit den Metadata Configurations (z.B. über die bean-config.xml) erstellt.
Innerhalb des Containers werden diese Bean-Definitionen als BeanDefintion-Objekte dargestellt, welche u.a. folgend Angaben besitzen
* Einen über eine package qualifizierter Klassennamen, meistens die tatsächliche Implementierungsklasse der zu definierenden Bean
* Ein Element, welches angibt, wie sich das Bean im Container verhalten soll (Scope, Lifecycle Callbacks, usw)
* Referenzen zu anderen Beans, welche benötigt werden. Diese Referenzen werden als Collaborators oder Dependencies bezeichnet.
* Andere Konfigurationseinstellungen, die in dem neue erstellen Objekt festgelegt werden soll

Da gibt es eine Tabelle welche diese Metadata Configuration in ein Set von Properties übersetzt, welche jeder Bean Defintion ausmacht.

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
erlauben die ApplicationContext-Implementierungen auch die Registrierung bestehender Objekte, die außerhalb des Containers (von Benutzern) erstellt werden. 
Dies geschieht durch den Zugriff auf die BeanFactory des ApplicationContext über die Methode getBeanFactory(), die die Implementierung der BeanFactory DefaultListableBeanFactory zurückgibt. 
DefaultListableBeanFactory unterstützt diese Registrierung durch die Methoden registerSingleton(..) und registerBeanDefinition(..). Typische Anwendungen arbeiten jedoch ausschließlich mit Beans, die durch reguläre Bean-Definitions-Metadaten definiert sind.

```text
Bean-Metadaten und manuell bereitgestellte Singleton-Instanzen müssen so früh wie möglich registriert werden, damit der Container sie während des Autowiring und anderer Introspektionsschritte richtig interpretieren kann.
Während das Überschreiben vorhandener Metadaten und vorhandener Singleton-Instanzen bis zu einem gewissen Grad unterstützt wird, wird die Registrierung neuer Beans zur Laufzeit (gleichzeitig mit dem Live-Zugriff auf die Factory) 
nicht offiziell unterstützt und kann zu Ausnahmen bei gleichzeitigem Zugriff, zu einem inkonsistenten Zustand im Bean-Container oder zu beidem führen.
```

### Beans benennen
