# Spring InitializingBean and DisposableBean Beispiel

In Spring sind InitializingBean und DisposableBean zwei Marker-Interfaces, eine nützliche Möglichkeit für Spring, bestimmte Aktionen bei der Initialisierung und Zerstörung einer Bean durchzuführen.

**Wichtig!**

Es wird nicht empfohlen die beiden genannten Beans zu verwenden, da sie den Business Logic Code unnötig an Spring koppeln.
Die bessere Variante ist die Verwendung von [Initialize und Destroy Methoden](/doc/dependencies/di/initialize_und_destroy_methoden.md)

Für die Verwendung der beiden Beans gilt folgendes:
* Für Beans, die **InitializingBean** implementiert haben, wird **afterPropertiesSet()** ausgeführt, nachdem alle Bean-Eigenschaften gesetzt wurden.
* Bei einer Bean, die als **DisposableBean** implementiert ist, wird **destroy()** ausgeführt, nachdem der Spring-Container die Bean freigegeben hat.


## [spring-bean-lifecycle-callbacks.xml](../../../src/main/resources/dependencies/lifecyclecallback/spring-bean-lifecycle-callbacks.xml)
Für das Beispiel wird eine einfache SpringBean definiert.
```xml
 <bean id="springBean"
       class="ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.SpringBeanLifecycleInterfaces">
    <property name="message" value="i'm property message"/>
</bean>
```
## [SpringBeanLifecycleInterfaces.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/SpringBeanLifecycleInterfaces.java)
Die Bean *SpringBeanLifecycleInterfaces* implementiert die beiden Interfaces **InitializingBean** und  **DisposableBean**
mit dessen Methoden **afterPropertiesSet()** und **destroy()**, welche implementiert werden müssen.
````java
public class SpringBeanLifecycleInterfaces implements InitializingBean, DisposableBean {

    private String message;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() +" afterPropertiesSet : " + message);
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Container is destroy " +this.getClass().getSimpleName());
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
````

## [SpringBeanLifecycleInterfacesRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/SpringBeanLifecycleInterfacesRunner.java)
Damit der Shutdown des Containers initiert werden kann, ruft die SpringBeanLifecycleInterfacesRunner Klasse den  **ConfigurableApplicationContext** anstelle des ApplicationContext auf 
und ermöglich so den ConfigurableApplicationContext zu **schliesssen**.
````java
ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/spring-bean-lifecycle-callbacks.xml");
SpringBeanLifecycleInterfaces bean = context.getBean(SpringBeanLifecycleInterfaces.class);
bean.sayHello();

context.close();
````

## output
````text
SpringBeanLifecycleInterfaces afterPropertiesSet : i'm property message
Hello from SpringBeanLifecycleInterfaces
Spring Container is destroy SpringBeanLifecycleInterfaces
````

## Referenzen
* [Blog über die Motivation Method Injection einzusetzen](https://spring.io/blog/2004/08/06/method-injection/)


## [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
