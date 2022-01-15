# Constructor argument index

Beim Index Konstruktor werden nicht die Typen angegeben, sondern die Indices.

**Der Index beginnt bei 0**.

````xml

<bean class="ch.wesr.spring.core.container.xml.beans.ConstructorBasedTypeMatchingBean">
    <constructor-arg index="0" value="5000"/>
    <constructor-arg index="1" value="Hallo Zahl"/>
</bean>
````

Code
Beispiel: [SimpleConstructorTypeIndexRunner.java](src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/SimpleConstructorTypeIndexRunner.java)

#### Constructor argument name

Die Argumente können aber auch über die Namen definiert werden Dabei spielte die Reihenfolge der Benennung der **
constructor-arg** keine Rolle.

````xml

<bean class="ch.wesr.spring.core.container.xml.beans.ConstructorBasedTypeMatchingBean">
    <constructor-arg name="zahl" value="5000"/>
    <constructor-arg name="hello" value="Hallo Zahl"/>
</bean>
````

Damit sich obiges Beispiel kompilieren lässt, muss der Code mit dem **Debug Flag** kompiliert werden!
Was aber in Intellij scheinbar default ist.

Wenn man den Code aber nicht mit dem **Debug-Flag** kompilieren will, kann man die **@ConstructorProperties
JDK-Annotation** verwenden, um das Konstruktorargumente explizit zu benennen.

Code
Beispiel: [SimpleConstructorNameRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/constructorbased/SimpleConstructorNameRunner.java)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
