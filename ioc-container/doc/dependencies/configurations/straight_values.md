# Straight Values (Primitives, Strings, ...)
Das *value* Attribut im \<property/> Element definiert ein Property oder ein Konstruktor Argument als einen lesbaren String.
Der Spring *conversion service* konvertiert dann diese Werte aus einem String in den effektiv verwendeten Typ.

Dabei werde die \<property/> Elemente bzw. deren Werte über die Setter Methoden in das Bean überführt.

````xml
<bean id="dataSource" class="ch.wesr.spring.core.container.xml.beans.BasicDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql:://localhost:3306/myDatabase"/>
    <property name="username" value="hans"/>
    <property name="password" value="muster"/>
</bean>
````
````java
public class BasicDataSource {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void sayHello() {
        System.out.println("Hello "+getUsername() +", du verbindest dich mit " +getUrl());
    }
}
````

Code Beispiel: [SimpleDataSource.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/straightvalues/SimpleDataSource.java)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
