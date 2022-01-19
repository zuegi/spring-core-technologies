# Spring depends-on Beispiel

Wenn eine BeanB von einer anderen BeanA abhängig ist, bedeutet dies in der Regel, dass die BeanB als Eigenschaft der BeanB festgelegt ist. 
Normalerweise wird dies mit dem **\<ref/>** Element in XML-basierten Konfigurationsmetadaten erreicht. 
Manchmal sind die Abhängigkeiten zwischen Beans jedoch weniger direkt. Ein Beispiel dafür ist, 
wenn ein statischer Initialisierer in einer Klasse ausgelöst werden muss, z. B. bei der Registrierung von Datenbanktreibern.
Das depends-on-Attribut kann explizit erzwingen, dass eine oder mehrere Beans initialisiert werden, bevor die Bean, 
die dieses Element verwendet, initialisiert wird. 


**deconcstruction-time**

Das Attribut depends-on kann sowohl eine Abhängigkeit zur Initialisierungszeit als auch, nur im Fall von Singleton-Beans, 
eine entsprechende Abhängigkeit zur Zerstörungszeit (deconstruction-time) angeben.

In das nachfolgende Beispiel übersetzt: 
Die DependsOnBean wird vor den beiden SpringBean1 und SpringBean zerstört (in dieser Reihenfolge) und bedeutet das *depends-on" Attribut kann auch die Reihenfolge der Zerstörung kontrollieren.


### [depends-on.xml](../../../src/main/resources/dependencies/dependson/depends-on.xml)
```xml
<bean id="springBean"  class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
<bean id="springBean1" class="ch.wesr.spring.core.container.xml.beans.SpringBean1"/>

<bean id="dependsOnBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.dependson.DependsOnBean" depends-on="springBean,springBean1">
    <property name="springBean" ref="springBean"/>
    <property name="springBean1" ref="springBean1"/>
</bean>
```
### [DependsOnBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/dependson/DependsOnBean.java)
````java
public class DependsOnBean {

    private SpringBean springBean;
    private SpringBean1 springBean1;

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName() + " mit: ");
        springBean.sayHello();
        springBean1.sayHello();
    }
    // getter und setter
}
````

### [SimpleDependsOnRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/dependson/SimpleDependsOnRunner.java)
````java
 ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/dependson/depends-on.xml");
DependsOnBean bean = context.getBean(DependsOnBean.class);
bean.sayHello();
````

### output
````text
Hello from DependsOnBean mit: 
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean1: ch.wesr.spring.core.container.xml.beans.SpringBean1@3b2da18f
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
