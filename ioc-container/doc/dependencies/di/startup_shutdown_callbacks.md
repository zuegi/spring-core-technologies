# Spring Startup und Shutdown Callback Beispiel

Ich bin nicht zufrieden mit diesem Modul
Die offizielle Spring Doku (siehe Referenz weiter unten) ist dürftig und meine Beispiele funktionieren nicht wie erwartet
Deshalb will ich hier keine Zeit mehr verlieren.

Mit den Interfaces 
* LifecycleProcessor
* SmartLifecycle
* Lifecycle
* Phased


ConfigurableApplicationContext
* close() -- Close this application context, destroying all beans in its bean factory.
* registerShutdownHook() -- Register a shutdown hook with the JVM runtime, closing this context on JVM shutdown unless it has already been closed at that time.

## [lifecycle-processor.xml](../../../src/main/resources/dependencies/lifecyclecallback/lifecycle-processor.xml)
```xml
<bean id="springBean"
      class="ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.startupshutdown.SpringBeanLifecycle"
>
</bean>
```
## [SpringBeanLifecycle.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/startupshutdown/SpringBeanLifecycle.java)
````java
public class SpringBeanLifecycle implements LifecycleProcessor, SmartLifecycle {

    private boolean running = false;

    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() +" sagt Hallo");
    }

    @Override
    public void onRefresh() {
        System.out.println(this.getClass().getSimpleName() + " - REFRESH.");
        running = true;
    }

    @Override
    public void onClose() {
        System.out.println(this.getClass().getSimpleName() + " - CLOSE.");
        running = false;
    }

    @Override
    public void start() {
        System.out.println(this.getClass().getSimpleName() + " - START.");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName() + " - STOP.");
        running = false;
    }

    public void stop(Runnable callback) {
        System.out.println(this.getClass().getSimpleName() + " callback: - STOP.");
        stop();
        callback.run();
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
````

## [DefaultLifecycleBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/startupshutdown/DefaultLifecycleBeanRunner.java)
````java
public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/lifecycle-processor.xml");
    context.registerShutdownHook();
    SpringBeanLifecycle bean = context.getBean(SpringBeanLifecycle.class);
    Thread.sleep(3000L);
    bean.sayHello();
}
````

## output
````text
SpringBeanLifecycle - START.
SpringBeanLifecycle sagt Hallo
SpringBeanLifecycle callback: - STOP.
SpringBeanLifecycle - STOP.
````

## Referenzen
* [Startup and Shutdown Callbacks](https://spring.getdocs.org/en-US/spring-framework-docs/docs/spring-core/beans/beans-factory-nature.html#beans-factory-lifecycle-processor)


## [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
