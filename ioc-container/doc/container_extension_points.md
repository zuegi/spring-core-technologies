# Spring Bean Container Extensions Points Beispiel

Der Spring IoC Container kann auf x verschiedene Arten erweitert werden.

* BeanPostProcessor

## Container Erweiterung mit dem BeanPostProcessor Interface

Das BeanPostProcessor Interface besteht aus 2 Methoden
```java
public interface BeanPostProcessor {
    @Nullable
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
```

Für jede Bean-Instanz, die vom Container erzeugt wird, erhält die BeanPostProcessor Implementierung sowohl 
vor dem Aufruf der Container-Initialisierungsmethoden als auch nach dem Aufruf der Bean-Initialisierungsmethoden (siehe [Lifecyce Callbacks]((../spring-ioc-container.md#LifecycleCallbacks)))
einen Callback vom Container.

### Registrierung einer Custom BeanPostProcessor Bean
Ein ApplicationContext erkennt automatisch alle Beans, die in den Konfigurationsmetadaten [CustomBeanPostProcessor.java](../src/main/java/ch/wesr/spring/core/container/xml/containerextensionpoints/CustomBeanPostProcessor.java)
definiert sind und das BeanPostProcessor Interface implementieren. In unserem Beispiel ist das die **CustomBeanPostProcessor** Baean.
Der Container bzw. ApplicationContext registriert diese Beans als Postprozessoren, damit sie später bei der Bean-Erstellung aufgerufen werden können.

Dann übergibt Spring jede Bean-Instanz an diese beiden Methoden vor und nach dem Aufruf der Initialisierungs-Callback-Methode,
in der Sie die Bean-Instanz nach Belieben verarbeiten können.
### [CustomBeanPostProcessor.java](../src/main/java/ch/wesr/spring/core/container/xml/containerextensionpoints/CustomBeanPostProcessor.java)
````java
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getSimpleName() +".postProcessBeforeInitialization() aufgerufen für: " +bean.getClass().getSimpleName() +", beanName: "+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getSimpleName() +".postProcessAfterInitialization() aufgerufen für: "+bean.getClass().getSimpleName() +", beanName" +beanName);
        return bean;
    }
}
````
### [bean-post-processor.xml](src/main/resources/dependencies/containerextensionpoints/bean-post-processor.xml)
In der [bean-post-processor.xml](src/main/resources/dependencies/containerextensionpoints/bean-post-processor.xml) sind die beiden Beans
**SpringBean** und **SpringBean2** konfiguriert, welche dann an die Methoden  
* postProcessBeforeInitialization()
* postProcessAfterInitialization()

des [CustomBeanPostProcessor.java](../src/main/java/ch/wesr/spring/core/container/xml/containerextensionpoints/CustomBeanPostProcessor.java)
übergeben werden und verarbeitet werden können.

````xml
 <bean id="springBean" class="ch.wesr.spring.core.container.xml.containerextensionpoints.SpringBean"
          init-method="customBeanInit" destroy-method="customBeanDestroy"/>

    <bean id="springBean2" class="ch.wesr.spring.core.container.xml.containerextensionpoints.SpringBean2"
          init-method="customBeanInit" destroy-method="customBeanDestroy"/>

    <bean id="customPostProcessorBean"
          class="ch.wesr.spring.core.container.xml.containerextensionpoints.CustomBeanPostProcessor"/>
````

### [SpringBean.java](src/main/java/ch/wesr/spring/core/container/xml/containerextensionpoints/SpringBean.java)
Zur Veranschaulichung wann, welche Callbacks ausgeführt werden, hat das **SpringBean** die verschiedenen Möglichkeiten 
der [Lifecycle Callbacks](../spring-ioc-container.md#LifecycleCallbacks) implementiert.
````java
public class SpringBean implements InitializingBean, DisposableBean {

    private String message;

    public SpringBean() {
        System.out.println("1. Eine Bean-Instanz wird entweder über einen Konstruktor oder durch eine Fabrikmethode erstellt.");
        System.out.println("\t" +this.getClass().getSimpleName() +" wird über den Konstruktor initalisiert");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("2. Setzen der Werte und Bean-Referenzen für die Bean-Eigenschaften");
        System.out.println("\tmessage: " +message);
        this.message = message;
    }

    public void sayHello() {
        System.out.println("7. Die Bean ist bereit, verwendet zu werden ");
        System.out.println("\t" +message +this.getClass().getSimpleName());
    }

    @PostConstruct
    public void sayPostConstructHello() {
        System.out.println("5. Aufruf der Initialisierungs-Callback-Methoden");
        System.out.println("\t" +this.getClass().getSimpleName() +".sayPostConstructHello(): aufgerufen weil mit @PostConstruct annotiert");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.1 Aufruf der Initialisierungs-Callback-Methoden");
        System.out.println("\t" +this.getClass().getSimpleName() + ".afterPropertiesSet(): aufgerufen aus dem InitializingBean");
    }

    public void customBeanInit() {
        System.out.println("5.2 Aufruf der Initialisierungs-Callback-Methoden");
        System.out.println("\t" +this.getClass().getSimpleName() + ".customBeanInit(): aufgerufen über das Bean Defintion Attribut init-method customBeanInit() ");
    }


    @PreDestroy
    public void sayPreDestroyGoodBy() {
        System.out.println("8.1 Aufruf der annotierten Destroy Methode");
        System.out.println("\t" +this.getClass().getSimpleName() + ".sayPreDestroyGoodBy(): aufgerufen weil mit @PreDestory annotiert");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("8.2 Aufruf der destroy() Methode aus dem DisposableBean Interface");
        System.out.println("\t" +this.getClass().getSimpleName() + ".destroy(): aufgerufen  aus dem DisposableBean");
    }

    public void customBeanDestroy() {
        System.out.println("8.3 Aufruf der im Attribut der Bean Definition definierten destroy-method");
        System.out.println("\t" +this.getClass().getSimpleName() + ".customBeanDestroy(): aufgerufen über das Bean Definition Atrribut destroy-method customBeanDestry() ");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("3. Aufruf der Setter-Methoden, die in allen bekannten Schnittstellen definiert sind");
        System.out.println("\t" +this.getClass().getSimpleName() + ".setBeanName(" +beanName +") aufgerufen aus dem BeanNameAware Interface");
    }
}
````

### [CustomBeanPostProcesserRunner.java](src/main/java/ch/wesr/spring/core/container/xml/containerextensionpoints/CustomBeanPostProcesserRunner.java)
````java
 public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/containerextensionpoints/bean-post-processor.xml");
    context.registerShutdownHook();

    SpringBean springBean = (SpringBean) context.getBean("springBean");
    springBean.sayHello();
    System.out.println("\nShutdown initalisiert:");
}
````

### output
```text
1. Eine Bean-Instanz wird entweder über einen Konstruktor oder durch eine Fabrikmethode erstellt.
	SpringBean wird über den Konstruktor initalisiert
2. Setzen der Werte und Bean-Referenzen für die Bean-Eigenschaften
	message: Hello from: 
3. Aufruf der Setter-Methoden, die in allen bekannten Schnittstellen definiert sind
	SpringBean.setBeanName(springBean) aufgerufen aus dem BeanNameAware Interface
4. Übergabe der Bean-Instanz an die Methode postProcessBeforeInitialization() jedes Bean-Postprozessors
	CustomBeanPostProcessor.postProcessBeforeInitialization() aufgerufen für: SpringBean, beanName: springBean
5. Aufruf der Initialisierungs-Callback-Methoden
5.1. Mit @PostConstruct annotierte Mehode
	SpringBean.sayPostConstructHello(): aufgerufen weil mit @PostConstruct annotiert
5.2. InitializingBean.afterSetProperties()
	SpringBean.afterPropertiesSet(): aufgerufen aus dem InitializingBean
5.3. Setter Methode über das Bean Definition Attribut init-method="customBeanInit()"
	SpringBean.customBeanInit(): aufgerufen über das Bean Defintion Attribut init-method customBeanInit() 
6. Übergabe der Bean-Instanz an die postProcessAfterInitialization()-Methode jedes Bean-Postprozessors
	CustomBeanPostProcessor.postProcessAfterInitialization() aufgerufen für: SpringBean, beanNamespringBean
7. Die Bean ist bereit, verwendet zu werden 
	Hello from: SpringBean
8. Wenn der Container heruntergefahren wird, werden die  Destory Callback Methoden aufgerufen
8.1 Aufruf der annotierten Destroy Methode
	SpringBean.sayPreDestroyGoodBy(): aufgerufen weil mit @PreDestory annotiert
8.2 Aufruf der destroy() Methode aus dem DisposableBean Interface
	SpringBean.destroy(): aufgerufen  aus dem DisposableBean
8.3 Aufruf der im Attribut der Bean Definition definierten destroy-method
	SpringBean.customBeanDestroy(): aufgerufen über das Bean Definition Atrribut destroy-method customBeanDestry() 
```
### Ablauf 
Es ist wichtig zu verstehen, wo genau das BeanPostProcessor Interface seinen Callback erfährt.
#### 1. Eine Bean-Instanz wird entweder über einen Konstruktor oder durch eine Fabrikmethode erstellt.
 ````java
public SpringBean() {
    System.out.println(this.getClass().getSimpleName() +" wird initalisiert");
}
````
#### 2. Setzen der Werte und Bean-Referenzen für die Bean-Eigenschaften
````xml
<bean id="springBean" class="ch.wesr.spring.core.container.xml.containerextensionpoints.SpringBean"
      init-method="customBeanInit" destroy-method="customBeanDestroy">
    <property name="message" value="Hello from: "/>
</bean>
````
````java
public void setMessage(String message) {
    System.out.println("2. Setzen der Werte und Bean-Referenzen für die Bean-Eigenschaften");
    System.out.println("\tmessage: " +message);
    this.message = message;
}
````
#### 3. Aufruf der Setter-Methoden, die in allen **aware** Schnittstellen definiert sind, z.B. BeanNameAware
````java
public class SpringBean implements BeanNameAware {
    // ...
    @Override
    public void setBeanName(String beanName) {
        System.out.println("3. Aufruf der Setter-Methoden, die in allen bekannten Schnittstellen definiert sind");
        System.out.println("\t" +this.getClass().getSimpleName() + ".setBeanName(" +beanName +") aufgerufen aus dem BeanNameAware Interface");
    }
    // ...
}
````
#### 4. Übergabe der Bean-Instanz an die Methode postProcessBeforeInitialization() jedes Bean-Postprozessors
````java
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("4. Übergabe der Bean-Instanz an die Methode postProcessBeforeInitialization() jedes Bean-Postprozessors");
        System.out.println("\t" +this.getClass().getSimpleName() +".postProcessBeforeInitialization() aufgerufen für: " +bean.getClass().getSimpleName() +", beanName: "+beanName);
        return bean;
    }
    // ...
}
````
#### 5. Aufruf der Initialisierungs-Callback-Methoden
##### 5.1 @PostConstruct annotierte Methode
````xml
    <!-- ermögliche die Annotations @PostConstruct/@PreDestroy und weitere -->
    <context:annotation-config/>
````
`````java
@PostConstruct
public void sayPostConstructHello() {
    System.out.println("5. Aufruf der Initialisierungs-Callback-Methoden");
    System.out.println("5.1. Mit @PostConstruct annotierte Mehode");
    System.out.println("\t" +this.getClass().getSimpleName() +".sayPostConstructHello(): aufgerufen weil mit @PostConstruct annotiert");
}
`````
##### 5.2 afterPropertiesSet() aus dem InitalizingBean
````java
public class SpringBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.2. InitializingBean.afterSetProperties()");
        System.out.println("\t" +this.getClass().getSimpleName() + ".afterPropertiesSet(): aufgerufen aus dem InitializingBean");
    }
}
````
#### 5.3 Bean Defintion Attribut method-init
````java
public void customBeanInit() {
    System.out.println("5.3. Setter Methode über das Bean Definition Attribut init-method=\"customBeanInit()\"");
    System.out.println("\t" +this.getClass().getSimpleName() + ".customBeanInit(): aufgerufen über das Bean Defintion Attribut init-method customBeanInit() ");
}
````

#### 6. Übergabe der Bean-Instanz an die postProcessAfterInitialization()-Methode jedes Bean-Postprozessors
````java
public class CustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("6. Übergabe der Bean-Instanz an die postProcessAfterInitialization()-Methode jedes Bean-Postprozessors");
        System.out.println("\t" +this.getClass().getSimpleName() +".postProcessAfterInitialization() aufgerufen für: "+bean.getClass().getSimpleName() +", beanName" +beanName);
        return bean;
    }
    // ...
}
````
#### 7. Die Bean ist bereit, verwendet zu werden 
````java
public void sayHello() {
    System.out.println("7. Die Bean ist bereit, verwendet zu werden ");
    System.out.println("\t" +message +this.getClass().getSimpleName());
}
````
#### 8. Wenn der Container heruntergefahren wird, werden die Destroy Callbacks aufgerufen

#### 8.1 @PreDestroy annotierte Methode
````java
@PreDestroy
public void sayPreDestroyGoodBy() {
    System.out.println("8.1 Aufruf der annotierten Destroy Methode");
    System.out.println("\t" +this.getClass().getSimpleName() + ".sayPreDestroyGoodBy(): aufgerufen weil mit @PreDestory annotiert");
}
````

#### 8.2 Disposable.destroy() Methode
````java
public class SpringBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("8.2 Aufruf der destroy() Methode aus dem DisposableBean Interface");
        System.out.println("\t" + this.getClass().getSimpleName() + ".destroy(): aufgerufen  aus dem DisposableBean");
    }
}
````

#### 8.3 Bean Defintion Attribut method-destroy
````java
public void customBeanDestroy() {
    System.out.println("8.3 Aufruf der im Attribut der Bean Definition definierten destroy-method");
    System.out.println("\t" +this.getClass().getSimpleName() + ".customBeanDestroy(): aufgerufen über das Bean Definition Atrribut destroy-method customBeanDestry() ");
}    
````


## Container Erweiterung mit dem BeanFactoryPostProcessor Interface



## Referenzen
* [How to do it in java - Spring BeanPostProcessor](https://howtodoinjava.com/spring-core/spring-bean-post-processors/)
* [Java by example - Spring BeanPostProcessor](http://www.javabyexamples.com/quick-guide-to-spring-beanpostprocessor)
* [tutorialspoint - Spring BeanPostProcessor](https://www.tutorialspoint.com/spring/spring_bean_post_processors.htm)
* [JavaDevJournal - Spring BeanPostProcessor](https://www.javadevjournal.com/spring/spring-bean-post-processor/)


## [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
