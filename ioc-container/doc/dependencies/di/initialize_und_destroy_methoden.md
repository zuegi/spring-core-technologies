# Spring Initialize und Destroy Methoden Beispiel

Wie schon erwähnt, ist es nicht empfehlenswert die beiden Spring-spezifischen *InitializingBean* und *DisposableBean*
als Callback Interfaces zu verwenden, da sie den Business Logic Code zu sehr an Spring koppeln.

Besser ist es daher Methoden wie init() oder destroy() auf den Beans zu schreiben.

Dazu gibt es 2 Methoden dem Spring IoC Container mitzuteilen wie er diese Methoden aufrufen kann.
* Jede Bean implementiert die **init()** / **destroy()** Methode und verwendet das **init-method** / **destroy-method** Attribut im Element \<bean/> der xml config.
* Im Toplevel Element \<beans/> der xml config werden die beiden Attribute default-init-method oder default-destroy-method definiert.

## Spezifische Bean Implementierung
### [per-bean-init-destroy-method.xml](../../../src/main/resources/dependencies/lifecyclecallback/per-bean-init-destroy-method.xml)
In der Bean Definition werden die Attribute **init-method** und **destry-method** definiert 
```xml
 <bean id="springBean"
       class="ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.InitDestroySpringBean"
       init-method="init"
       destroy-method="destroy"
/>
```
### [InitDestroySpringBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/InitDestroySpringBean.java)
````java
public class InitDestroySpringBean {


    public void init() {
        System.out.println(this.getClass().getSimpleName() +" init() called ");
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    public void destroy() {
        System.out.println("Spring Container is destroy " +this.getClass().getSimpleName());
    }

}
````

### [InitDestroySpringBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/InitDestroySpringBeanRunner.java)
Beachte die Verwendung des **ConfigurableApplicationContext** anstelle des ApplicationContext, damit die close() Methode aufgerufen werden kann.
````java
ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/per-bean-init-destroy-method.xml");
InitDestroySpringBean bean = context.getBean(InitDestroySpringBean.class);
bean.sayHello();

context.close();
````

### output
````text
InitDestroySpringBean init() called 
Hello from InitDestroySpringBean
Spring Container is destroy InitDestroySpringBean
````

## Globale Container Implementierung
Global bedeutet hier innerhalb eines ApplicationContext bzw. Spring IoC Container.

## [beans-default-init-destroy-method.xml](../../../src/main/resources/dependencies/lifecyclecallback/beans-default-init-destroy-method.xml)
Die beiden Attribute **default-init-method** und **default-destroy-method** werden auf dem Toplevel Element \<beans/> definiert.
Der Container wird für jede Bean Defintion die init() und destroy() Methode (sofern implementiert) aufrufen.
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
       default-init-method="init"
       default-destroy-method="destroy"
>

    <bean id="springBean"
          class="ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.InitDestroySpringBean"
    />

</beans>
```
### [InitDestroySpringBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/InitDestroySpringBean.java)
````java
public class InitDestroySpringBean {
    
    public void init() {
        System.out.println(this.getClass().getSimpleName() +" init() called ");
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    public void destroy() {
        System.out.println("Spring Container is destroy " +this.getClass().getSimpleName());
    }

}
````

### [DefaultInitDestroySpringBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lifecyclecallback/DefaultInitDestroySpringBeanRunner.java)
````java
ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/beans-default-init-destroy-method.xml");
InitDestroySpringBean bean = context.getBean(InitDestroySpringBean.class);
bean.sayHello();

context.close();
````

### output
````text
InitDestroySpringBean init() called 
Hello from InitDestroySpringBean
Spring Container is destroy InitDestroySpringBean
````

## [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
