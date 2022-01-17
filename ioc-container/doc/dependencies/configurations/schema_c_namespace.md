# Verwendung des c-namespace aus dem Spring Xml Schema

Beachte die Verwendung des *Schema c* **xmlns:p="http://www.springframework.org/schema/p"**
Mit dem p-namespace (p:<variablenname>) kann mann die Attribute des Bean-Elements (anstelle von verschachtelten <property/>-Elementen) verwenden.

Spring unterstützt erweiterbare Konfigurationsformate mit Namespaces, die auf einer XML-Schema-Definition beruhen.
Der p-Namespace ist jedoch nicht in einer XSD-Datei definiert und existiert nur im Kern von Spring.

In folgendem Beispiel wird auch ein spezielles Format verwendet.
Mit der Definition **p:springBean-ref="springBean** wird eine Referenz auf das SpringBean konfiguriert.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
    <bean id="dataSource" class="ch.wesr.spring.core.container.xml.beans.BasicDataSource"
          p:driverClassName="com.mysql.jdbc.Driver"
          p:url="jdbc:mysql:://localhost:3306/myDatabase"
          p:username="hans"
          p:password="muster"
          p:springBean-ref="springBean"
    />
</beans>
```
Verwendet man für den p-namespace eine IDE wie IntelliJ wird man dabei auch wunderbar unterstützt und die Gefahr auf Schreibfehler vermindert sich massiv.
### [BasicDataSource.java](../../../src/main/java/ch/wesr/spring/core/container/xml/beans/BasicDataSource.java)
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
### [SimplePDataSource.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/schemanamespaces/SimplePDataSource.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("schema-namespaces/p-basic-datasource.xml");

BasicDataSource bean = context.getBean(BasicDataSource.class);
bean.sayHello();
````

Output
````text
Hello hans, du verbindest dich mit jdbc:mysql:://localhost:3306/myDatabase
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
