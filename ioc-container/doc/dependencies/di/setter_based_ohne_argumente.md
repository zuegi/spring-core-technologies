# Setter based ohne Argumente

Setter beased Dependency Injection wird erreicht, indem der Container Setter Methoden der Beans aufruft. Dazu muss der
Container das zu injizierende (to be injected) Bean über einen Konstruktor ohne Argumente oder eine statische Factory
Methode ohne Argument instanzieren.

Zuerst werden beide Beans in der xml Datei definiert. Dabei wird dem **setterBasedBean** über ein \<property/> die
SpringBean als Referenz mitgegeben.

````xml

<bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="setterBasedBean" class="ch.wesr.spring.core.container.xml.beans.SetterBasedBean">
<property name="springBean" ref="springBean"/>
</bean>
````

Das SetterBean selber ist eine ganz einfache Pojo Klasse ohne Firlefanz.

````java
public class SetterBasedBean {

    // SetterBased Bean hat eine Dependency zu SpringBean
    private SpringBean springBean;

    // eine Setter Methode, sodass der Container die SpringBean injecten kann
    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
        System.out.println("springBean wurde gesetzt in " + this.getClass().getName());
    }

    public void sayHello() {
        springBean.sayHello();
    }
}
````

Wie gewohnt kann über den ApplicationContext die SetterBaseBean aufgerufen werden.

```java
ApplicationContext context=new ClassPathXmlApplicationContext("setter-based.xml");

SetterBasedBean bean=context.getBean(SetterBasedBean.class);
bean.sayHello();
```

Code
Beispiel: [SimpleSetterDIRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/setterbased/SimpleSetterDIRunner.java)



###[zurück zu spring-ioc-container](../../../spring-ioc-container.md)
