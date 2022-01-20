# Spring lazy-init Beispiel

Standardmäßig erstellen und konfigurieren ApplicationContext-Implementierungen
im Rahmen des Initialisierungsprozesses eagerly alle Singleton-Beans. 
Im Allgemeinen ist diese Vorinstanziierung wünschenswert, da Fehler in der Konfiguration 
oder der Umgebung sofort entdeckt werden, im Gegensatz zu Stunden oder sogar Tagen später. 
Wenn dieses Verhalten nicht erwünscht ist, kann man die Vorinstanziierung einer Singleton-Bean 
verhindern, indem Sie die Bean-Definition als "lazy-initialized" markieren. 
Eine lazy-initialisierte Bean weist den IoC-Container an, eine Bean-Instanz zu erstellen, 
wenn sie zum ersten Mal angefordert wird, und nicht erst beim Starten.


**Wie zu beweisen?**

Aktuell verstehe ich gerade nicht wie ich das beweisen kann.
### [lazy-init.xml](../../../src/main/resources/dependencies/lazyinit/lazy-init.xml)
```xml
<bean id="lazy" class="ch.wesr.spring.core.container.xml.dependencyinjection.lazyinit.LazyInitBean" lazy-init="true"/>
<bean id="springBean" name="customBean, dedicatedBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
```
### [LazyInitBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lazyinit/LazyInitBean.java)
````java
hier steht der Java Code
````

Wie beweisen, die Bean Definition ist ja vorhanden, deshalb wird die LazyBean bei 
der Methode "context.getBeanDefinitionNames* auch ausgewiesen
### [SimpleLazyInitBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/lazyinit/SimpleLazyInitBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lazyinit/lazy-init.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
        System.out.println("Vorhandene Bean: "+ beanDefinitionName);
        }

        LazyInitBean bean = context.getBean(LazyInitBean.class);
        if (bean == null) {
        System.out.println("LazyInitbean ist noch nicht erstellt/initialisiert");
        }
````

### output
````text
Vorhandene Bean: springBean
Vorhandene Bean: springBean1
Vorhandene Bean: lazy
````

Zudem kann man den ganzen **Container** auf lazy loading setzen
```xml
<beans default-lazy-init="true">
      <!-- no beans will be pre-instantiated... -->
</beans>
```

## Referenzen
[Lazy Initialization in Spring Boot](https://springhow.com/lazy-initialization-in-spring-boot/)

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
