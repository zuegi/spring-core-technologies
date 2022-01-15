# Spring idref Beispiel

Das idref-Element ist einfach eine fehlerfreie Möglichkeit, die id (ein String-Wert - keine Referenz) einer anderen Bean
im Container an ein \<constructor-arg/>- oder \<property/>-Element zu übergeben.

````xml

<bean name="justAnotherBean" class="ch.wesr.spring.core.container.xml.beans.JustAnotherBean">
</bean>

<bean name="simpleIdRefBean" class="ch.wesr.spring.core.container.xml.beans.IdRefBean">
    <property name="irgendEinString">
        <idref bean="justAnotherBean"/>
    </property>
</bean>
````

````java
public class IdRefBean {

   String irgendEinString;

    public void sayHello() {
        System.out.println("Das ist die Bean als String: " +irgendEinString);
    }

    public String getIrgendEinString() {
        return irgendEinString;
    }

    public void setIrgendEinString(String irgendEinString) {
        this.irgendEinString = irgendEinString;
    }
}
````

````java
public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("idref/idref-configuration.xml");

        IdRefBean bean = context.getBean(IdRefBean.class);
        bean.sayHello();
    }
````
output
````text
Das ist die Bean als String: justAnotherBean
````

Code Beispiel: [SimpleIdRefRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/idref/SimpleIdRefRunner.java)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
