# Verwendung des p-namespace aus dem Spring Xml Schema

Beachte die Verwendung des *Schema p* **xmlns:p="http://www.springframework.org/schema/p"**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dataSource" class="ch.wesr.spring.core.container.xml.beans.BasicDataSource"
        p:driverClassName="com.mysql.jdbc.Driver"
        p:url="jdbc:mysql:://localhost:3306/myDatabase"
        p:username="hans"
        p:password="muster"
    />
</beans>
```
Verwendet man für den p-namespace eine IDE wie IntelliJ wird man dabei auch wunderbar unterstützt und die Gefahr auf Schreibfehler vermindert sich massiv.

Code Beispiel: [SimplePDataSource.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/straightvalues/SimplePDataSource.java)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
