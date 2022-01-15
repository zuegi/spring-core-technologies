# Constructor Argument Resolution

Die Konstruktor Argument Auflösung erfolgt über den Typ des Arguments. Sind die **<constructor-arg/>** eindeutig, z.B.
wenn ein anderes Bean referenziert wird, so muss die Reihenfolge Argumente der Bean-Definition

````xml
<bean class="ch.wesr.spring.core.container.xml.beans.ConstructorBasedBean">
    <constructor-arg ref="springBean1"/>
    <constructor-arg ref="springBean"/>
    <-- in untenstehendem Konstruktor ist die Defintion des SpringBean an erster Stelle
</bean>

<bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>

<bean id="springBean1" class="ch.wesr.spring.core.container.xml.beans.SpringBean1"/>
````

und die Reihenfolge der Argumente im Konstruktor nicht übereinstimmen.

````java
public class ConstructorBasedBean {

    public ConstructorBasedBean(SpringBean springBean, SpringBean1 springBean1) {
        // ...
    }
}
````

Code
Beispiel: [SimpleConstructorBasedRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/constructorbased/SimpleConstructorBasedRunner.java)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
