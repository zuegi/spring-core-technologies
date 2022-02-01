# Spring Bean Definition Inheritance Beispiel

Es gibt 2 Arten von Bean Inheritance (Vererbung) in Spring
* ohne Template
* mit Template

Zudem kann beide Varianten in der **xml Configuration**, als auch in der **Java Annotation** Form anwenden.

## Bean Definition Inheritance ohne Template mit einer XML Konfiguration
Im nachfolgenden Code erbt die _Child_ **SpringBean** von der _Parent_ **BaseSpringBean** unter Verwendung
des Attributs **parent**. Daher wird die übergeordnete Definition von der untergeordneten Bean 
geerbt. 

**Beachte** aber, dass die untergeordnete Bean **SpringBean** die Eigenschaft **name** und übergeordneten **BaseSpringBean** überschreibt.


### [bean-definition-inheritance.xml](../src/main/resources/dependencies/inheritance/bean-definition-inheritance.xml)
```xml
<bean id="baseBean" class="ch.wesr.spring.core.container.xml.beaninheritance.BaseSpringBean" >
    <property name="name" value="Starte mit BaseSpringBean"/>
</bean>
<bean id="springBean" class="ch.wesr.spring.core.container.xml.beaninheritance.SpringBean"
      parent="baseBean"
/>
```

### [SpringBean.java](../src/main/java/ch/wesr/spring/core/container/xml/beaninheritance/SpringBean.java)
````java
public class SpringBean {

    private String baseName;
    private String name;

    public void sayHello() {
        System.out.println("Hello from " +getName() +" mit baseName: " +getBaseName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
````


### [BaseSpringBean.java](../src/main/java/ch/wesr/spring/core/container/xml/beaninheritance/BaseSpringBean.java)
````java
public class BaseSpringBean {

    private String name;
    private String baseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
````

### [SimpleBeanInheritanceRunner.java](../src/main/java/ch/wesr/spring/core/container/xml/beaninheritance/SimpleBeanInheritanceRunner.java)
````java
public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/inheritance/bean-definition-inheritance.xml");
    SpringBean springBean = (SpringBean) context.getBean("springBean");

    springBean.sayHello();
}
````

### output
````text
Hello from SpringBean mit baseName: Starte mit BaseSpringBean
````

## Bean Definition Inheritance mit Template mit einer XML Konfiguration

Manchmal muss man Abstrakte Klassen als vererbende Bean definieren. Man spricht dann auch von einem Template.

In der XML Konfiguration muss diese Abstrakte Klasse mit dem Attribut **abstract="true"** gesetzt werden.

## [abstract-bean-definition-inheritance.xml](../src/main/resources/dependencies/inheritance/abstract-bean-definition-inheritance.xml)
```xml
<bean id="baseBean" class="ch.wesr.spring.core.container.xml.beaninheritance.BaseSpringBean" abstract="true">
    <property name="baseName" value="Starte mit BaseSpringBean"/>
</bean>
<bean id="springBean" class="ch.wesr.spring.core.container.xml.beaninheritance.SpringBean"
      parent="baseBean"
/>
```

Die abstracte Klasse erfährt bis auf die Deklaration **abstract* und die Bezeichnung 
vor allem inhaltlich keine nennenswerten Veränderung gegenüber der Klasse 
[BaseSpringBean.java](../src/main/java/ch/wesr/spring/core/container/xml/beaninheritance/BaseSpringBean.java)  

[AbstractBaseSpringBean.java](../src/main/java/ch/wesr/spring/core/container/xml/beaninheritance/AbstractBaseSpringBean.java)
````java
abstract class AbstractBaseSpringBean {

    private String name;
    private String baseName;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
````
In der main Methode wird die entsprechende xml Konfiguration 
[abstract-bean-definition-inheritance.xml](../src/main/resources/dependencies/inheritance/abstract-bean-definition-inheritance.xml)
angezogen.

### [SimpleBeanInheritanceRunner.java](../src/main/java/ch/wesr/spring/core/container/xml/beaninheritance/SimpleBeanInheritanceRunner.java)
````java
public static void main(String[] args){
    System.out.println("Spring Bean Definition Inheritance mit Template (AbstractBaseBean)");
    ApplicationContext context2=new ClassPathXmlApplicationContext("dependencies/inheritance/abstract-bean-definition-inheritance.xml");
    SpringBean springBean2=(SpringBean)context.getBean("springBean");

    pringBean2.sayHello();
}
````

## Referenzen
* [Spring Guru - spring-bean-definition-inheritance](https://springframework.guru/spring-bean-definition-inheritance/)


## [zurück zu spring-ioc-container](../spring-ioc-container.md)
