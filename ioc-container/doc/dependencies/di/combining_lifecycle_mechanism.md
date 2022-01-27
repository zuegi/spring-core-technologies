# Spring Combining Lifecycle Mechanisms Beispiel

Es gibt 3 verschiedene Arten den Lebenszyklus einer Bean zu kontrollieren:
* Lifecycle Interfaces InitializingBean und DisposableBean
* Custom methoden wie init() und destroy() 
* Die @PostConstruct und @PreDestroy Annotationen.

Wenn mehrere Lebenszyklusmechanismen für eine Bean konfiguriert sind und 
jeder Mechanismus mit einem anderen Methodennamen konfiguriert ist, 
wird jede konfigurierte Methode in der Reihenfolge ausgeführt, die nach diesem Hinweis aufgeführt ist. 
Wenn jedoch derselbe Methodenname - z. B. init() für eine Initialisierungsmethode - für mehr als 
einen dieser Lebenszyklusmechanismen konfiguriert ist, wird diese Methode einmal ausgeführt, 
wie im vorangegangenen Abschnitt erläutert.

## Die Reihenfolge der verschiedenen Initalisierungsmethoden ist folgende:
1. Methoden mit der Annotation @PostConstruct
2. afterPropertiesSet() Methode definiert über die InitializingBean
3. Eine Custom Methode, z.b. init()

## Die Reihenfolge der verschiedene Zerstörungsmethoden ist folgende:
1. Methoden mit der Annotation @PreDestroy
2. Die destroy() Methode definiert über das DisposableBean
3. Eine Custom Methode, z.b. destroy()


Folgendes Beispiel zeigt die verschiedenen Mechanism auf
## [combine-multiple-lifecycle.xml](../../../src/main/resources/dependencies/lifecyclecallback/combine-multiple-lifecycle.xml)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd"
       default-init-method="customBeanInit"
       default-destroy-method="customBeanDestroy"
>
    <!-- ermögliche die Annotations @PostConstruct/@PreDestroy und weitere -->
    <context:annotation-config/>

    <bean id="springBean"
          class="ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.combinemultiple.SpringBean"/>
</beans>
```
## [SpringBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/combinemultiple/SpringBean.java)
````java
public class SpringBean implements InitializingBean, DisposableBean {

    @PostConstruct
    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() +": aufgerufen über die mit @PostConstruct annotierte Methode sayHello()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die  afterPropertiesSet() aus dem InitializingBean");
    }

    public void customBeanInit() {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die custom method customBeanInit() ");
    }


    @PreDestroy
    public void sayGoodBy() {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die mit @PreDestory annotierte Methode sayGoodBy()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen  über die  destory() Methode  aus dem DisposableBean");
    }

    public void customBeanDestroy() {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die custom method customBeanDestry() ");
    }
}
````

## [MultipleCombinedLifecycleBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/combinemultiple/MultipleCombinedLifecycleBeanRunner.java)
````java
System.out.println("Initialsiere den Spring Container");
ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/combine-multiple-lifecycle.xml");
SpringBean bean = context.getBean(SpringBean.class);

System.out.println("\nShutdown des Spring Container");
context.close();
````

## output
````text
Initialsiere den Spring Container
SpringBean: aufgerufen über die mit @PostConstruct annotierte Methode sayHello()
SpringBean: aufgerufen über die  afterPropertiesSet() aus dem InitializingBean
SpringBean: aufgerufen über die custom method customBeanInit() 

Shutdown des Spring Container
SpringBean: aufgerufen über die mit @PreDestory annotierte Methode sayGoodBy()
SpringBean: aufgerufen  über die  destory() Methode  aus dem DisposableBean
SpringBean: aufgerufen über die custom method customBeanDestry() 
````

## Referenzen
keine
## [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
