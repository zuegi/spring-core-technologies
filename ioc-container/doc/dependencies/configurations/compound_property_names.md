# Spring compound property names Beispiel

Die [CompoundPropertyNamesBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/compoundpropertynames/CompoundPropertyNamesBean.java)
hat ein Fred Attribut, welches ein Bob Attribut, welches ein Sam Attribut, welches ein age Attribut besitzt, 
was den Wert 88 übertragen bekommt

### [xml-config-datei.xml](../../../src/main/resources/ref/simple-ref.xml)
```xml
<bean id="fred" class="ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames.SpringBeanFred">
    <property name="bob" ref="bob"/>
</bean>
<bean id="bob" class="ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames.SpringBeanBob">
<property name="sam" ref="sam"/>
</bean>
<bean id="sam" class="ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames.SpringBeanSam"/>

<bean id="compoundPropertyNameBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames.CompoundPropertyNamesBean">
<property name="fred" ref="fred"/>
<property name="fred.bob.sam.age" value="88" />
</bean>
```
### [CompoundPropertyNamesBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/compoundpropertynames/CompoundPropertyNamesBean.java)
````java
public class CompoundPropertyNamesBean {

    private SpringBeanFred fred;

    public SpringBeanFred getFred() {
        return fred;
    }

    public void setFred(SpringBeanFred fred) {
        this.fred = fred;
    }

    public void sayHello() {
        System.out.println("Sam ist " + fred.getBob().getSam().getAge() + " Jahre alt");
    }
}
````

### [CompoundPropertyNamesBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/compoundpropertynames/CompoundPropertyNamesBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("compoundpropertynames/compound-property-names.xml");
CompoundPropertyNamesBean bean = context.getBean(CompoundPropertyNamesBean.class);
bean.sayHello();
````

### output
````text
Sam ist 88 Jahre alt
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
