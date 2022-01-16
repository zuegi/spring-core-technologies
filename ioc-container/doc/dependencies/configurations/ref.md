# Spring ref Beispiel

Das *ref* Element wird als finales Element innerhalb von \<property/> oder \<constructor-arg/> verwendet.

Dabei wird über ein definiertes Property/Attribut einer Bean eine Referenz auf ein anderes Bean (Collaborator) als Wert übergeben.
Alle Referenzen sind letztendlich eine Referenz auf ein anderes Objekt. Scoping und Validierung hängen davon ab, 
ob Sie die ID oder den Namen des anderen Objekts über das Bean- oder Parent-Attribut angeben.

## Ein ref Beispiel im selben Container
Die referenzierte Bean *justAnotherBean* ist ein Ahängigkeit zur Bean *refBean*.
*refBean* wird nach Bedarf erstellt - erst danach wird der Wert des Property *justAnotherBean* gesetzt.
In diesem Fall ist der Collaborator (*justAnotherBean* von der Klasse SpringBean.java) eine Singleton-Bean und wurde bereits vom Container erstellt.

###[simple-ref.xml](../../../src/main/resources/ref/simple-ref.xml)
```xml
<bean name="justAnotherBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean" />
<bean name="refBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.ref.RefBean">
    <property name="justAnotherBean">
        <ref bean="springBean" />
    </property>
</bean>
```

### [RefBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/ref/RefBean.java)
````java
public class RefBean {

    private SpringBean springBean;

    public SpringBean getSpringBean() {
        return springBean;
    }

    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }

    public void sayHello() {
        System.out.println(this.getClass().getName());
        springBean.sayHello();
    }
}
````

### [SimpleRefRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/ref/SimpleRefRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("ref/simple-ref.xml");

RefBean bean = context.getBean(RefBean.class);
bean.sayHello();
````

### output
````text
ch.wesr.spring.core.container.xml.dependencyinjection.ref.RefBean
Hello from ch.wesr.spring.core.container.xml.beans.SpringBean
````


### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)

