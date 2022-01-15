# Constructor argument type matching

Wenn ein einfacher Typ verwendet wird, wie z.B. \<value>true\</value>, kann Spring den Typ des Wertes nicht bestimmen
und kann daher nicht ohne Hilfe nach Typ abgleichen. Der Container kann einfache Typen nur auflösen, wenn diese in der
Bean Definition mit dem **type** Attribut angegeben werden.

Diese Auflösung erfolgt über eine Bean Definition

````xml

<bean class="ch.wesr.spring.core.container.xml.beans.ConstructorBasedTypeMatchingBean">
    <constructor-arg type="int" value="5000"/>
    <constructor-arg type="java.lang.String" value="Hallo Zahl"/>
</bean>
````

und der entsprechenden Deklaration im Konstruktor

````java
public class ConstructorBasedTypeMatchingBean {
    private final int zahl;
    private final String hello;

    public ConstructorBasedTypeMatchingBean(int zahl, String hello) {
        this.zahl = zahl;
        this.hello = hello;
    }
}
````

Code
Beispiel: [SimpleConstructorTypeMatchingRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/constructorbased/SimpleConstructorTypeMatchingRunner.java)

###[zurück zu spring-ioc-container](../../../spring-ioc-container.md)
