# Spring Inner Bean Beispiel

Ein \</bean> Element innerhalb eines \<property/> oder \<constructor-arg/> Element wird als Inner Bean bezeichnet.
Eine Inner Bean braucht kein *id* oder *name* Attribut. Der Container beachtet auch keine Scopes der Inner Bean, 
weil diese immer anonym und und mit der Outer Bean erstellt werden. So ist es auch nicht möglich Inner Beans direkt von aussen zu zugreifen
oder einer anderen Bean zu injected.

**Spezialfall**
Es möglich, destruction callbacks von einem benutzerdefinierten Scopt zu erhalten - zum Beispiel für eine request-scoped Inner Bean, die in einer Singleton-Bean enthalten ist. 
Die Erstellung der Inner Bean-Instanz ist an die Outer Bean gebunden, aber Destruction-Callbacks lassen sie am Lebenszyklus des Request-Scopes teilnehmen. 
Dies ist kein übliches Szenario. Innere Beans teilen sich in der Regel einfach den Geltungsbereich der sie enthaltenden Bean.

## Beispiel Inner Bean via \<property/> Element

### [inner-bean.xml](../../../src/main/resources/dependencies/inner/property-inner-bean.xml)
```xml
<bean id="outerBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.inner.OuterBean">
    <property name="innerBean">
        <bean class="ch.wesr.spring.core.container.xml.dependencyinjection.inner.InnerBean">
            <property name="name" value="René"/>
            <property name="alter" value="52"/>
        </bean>
    </property>
</bean>
```
### [InnerBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/inner/InnerBean.java)
````java
public class InnerBean {
    private String name;
    private int alter;

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        System.out.println("\tMeine Atrributte sind ->  name: " + name + ", alter: " + alter);

    }
    // ... getter und setter
}
````

### [OuterBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/inner/OuterBean.java)
````java
public class OuterBean {

    private InnerBean innerBean;

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        innerBean.sayHello();
    }
    // .. getter und setter
}
````

### [OuterBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/inner/OuterBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("inner/inner-bean.xml");

OuterBean bean = context.getBean(OuterBean.class);
bean.sayHello();
````

### output
````text
Hello from OuterBean
Hello from InnerBean
	Meine Atrributte sind ->  name: René, alter: 52
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)

## Beispiel via \<constructor-arg/> Element

###[constructor-arg-inner-bean.xml](../../../src/main/resources/dependencies/inner/constructor-arg-inner-bean.xml)
```xml
<bean id="outerBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.inner.ConstructorArgOuterBean">
    <constructor-arg name="innerBean">
        <bean class="ch.wesr.spring.core.container.xml.dependencyinjection.inner.InnerBean">
            <property name="name" value="René"/>
            <property name="alter" value="52"/>
        </bean>
    </constructor-arg>
</bean>
```
### [InnerBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/inner/InnerBean.java)
Die Inner Bean bleibt unverändert
````java
public class InnerBean {
    private String name;
    private int alter;

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        System.out.println("\tMeine Atrributte sind ->  name: " + name + ", alter: " + alter);

    }
    // ... getter und setter
}
````

### [ConstructorArgOuterBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/inner/ConstructorArgOuterBean.java)
````java
public class ConstructorArgOuterBean {

    private InnerBean innerBean;

    public ConstructorArgOuterBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        innerBean.sayHello();
    }
}
````

### [ConstructorArgOuterBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/inner/ConstructorArgOuterBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("inner/constructor-arg-inner-bean.xml");
ConstructorArgOuterBean bean = context.getBean(ConstructorArgOuterBean.class);

bean.sayHello();
````

### output
````text
Hello from ConstructorArgOuterBean
Hello from InnerBean
	Meine Atrributte sind ->  name: René, alter: 52
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
