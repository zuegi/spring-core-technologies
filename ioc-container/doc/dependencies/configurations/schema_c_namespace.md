# Verwendung des c-namespace aus dem Spring Xml Schema

Beachte die Verwendung des *Schema c* **xmlns:c="http://www.springframework.org/schema/c"**
Mit dem c-namespace (c:<variablenname>) kann mann die Attribute des Bean-Elements (anstelle von verschachtelten \<constructor-arg/>-Elementen) verwenden.

Spring unterstützt erweiterbare Konfigurationsformate mit Namespaces, die auf einer XML-Schema-Definition beruhen.
Der c-Namespace ist jedoch nicht in einer XSD-Datei definiert und existiert nur im Kern von Spring.

In folgendem Beispiel wird auch ein spezielles Format verwendet.
Mit der Definition **c:springBean-ref="springBean** wird eine Referenz auf das SpringBean konfiguriert.

### [c-basic-datasource.xml](../../../src/main/resources/dependencies/schema-namespaces/c-basic-datasource.xml)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
    <bean id="springBean1" class="ch.wesr.spring.core.container.xml.beans.SpringBean1"/>

    <bean class="ch.wesr.spring.core.container.xml.beans.ConstructorBasedBean">
        <constructor-arg ref="springBean1"/>
        <constructor-arg ref="springBean"/>
    </bean>

    <bean id="cNameSpaceBean"
          class="ch.wesr.spring.core.container.xml.dependencyinjection.schemanamespaces.AnotherConstructorBasedBean"
          c:springBean-ref="springBean"
          c:springBean1-ref="springBean1"
    />
</beans>

```
Verwendet man für den c-namespace eine IDE wie IntelliJ wird man dabei auch wunderbar unterstützt und die Gefahr auf Schreibfehler vermindert sich massiv.
### [AnotherConstructorBasedBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/schemanamespaces/AnotherConstructorBasedBean.java)
````java
public class BasicDataSource {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private SpringBean springBean;

    public void sayHello() {
        System.out.println("Hello "+getUsername() +", du verbindest dich mit " +getUrl());
        springBean.sayHello();
    }
````

### [ConstructorBasedBean](../../../src/main/java/ch/wesr/spring/core/container/xml/beans/ConstructorBasedBean.java)
````java
public class ConstructorBasedBean {

    private SpringBean springBean;
    private SpringBean1 springBean1;

    public ConstructorBasedBean(SpringBean springBean, SpringBean1 springBean1) {
        this.springBean = springBean;
        this.springBean1 = springBean1;
    }

    public void sayHello() {
        springBean.sayHello();
        springBean1.sayHello();
    }
}
````

### [SimpleCDataSource.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/schemanamespaces/SimpleCDataSource.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("schema-namespaces/c-basic-datasource.xml");

ConstructorBasedBean bean = context.getBean(ConstructorBasedBean.class);
bean.sayHello();

AnotherConstructorBasedBean anotherConstructorBasedBean = context.getBean(AnotherConstructorBasedBean.class);
anotherConstructorBasedBean.sayHello();
````

Output
````text
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean1: ch.wesr.spring.core.container.xml.beans.SpringBean1@4d826d77

Hello from AnotherConstructorBasedBean: 
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean1: ch.wesr.spring.core.container.xml.beans.SpringBean1@4d826d77
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
