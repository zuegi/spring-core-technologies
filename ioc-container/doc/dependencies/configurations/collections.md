# Spring Collections Beispiel

Die Elemente \<list/>, \<set/>, \<map/> und \<props/> setzen die Eigenschaften und Argumente der Java Collection-Typen List, 
Set, Map und Properties. Das folgende Beispiel zeigt, wie sie zu verwenden sind:

### [collections.xml](../../../src/main/resources/collections/collections.xml)
```xml
 <bean id="springBean1" name="customBean, dedicatedBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.collections.SpringBean1"/>
<bean id="springBean2" name="customBean1, dedicatedBean1" class="ch.wesr.spring.core.container.xml.dependencyinjection.collections.SpringBean2"/>

<bean id="komplexeBean" class="ch.wesr.spring.core.container.xml.dependencyinjection.collections.KomplexeBean">
<property name="emails">
    <props>
        <prop key="chef">chef@firlefanz.org</prop>
        <prop key="sous-chef">sour.chef@firlefanz.org</prop>
        <prop key="sous-sous-chef">sous.sous.chef@firlefanz.org</prop>
    </props>
</property>

<property name="kundenListe">
    <list>
        <value>Paperlapapp AG</value>
        <value>Gibt es gar nicht Gmbh</value>
        <value>Enterprise AG</value>
    </list>
</property>

<property name="beanListe">
    <list>
        <ref bean="springBean1"/>
        <ref bean="springBean2"/>
    </list>
</property>

<property name="beanMap">
    <map>
        <entry key="springBean1" value-ref="springBean1"/>
        <entry key="springBean2" value-ref="springBean2"/>
    </map>
</property>

<property name="beanSet">
    <set>
        <ref bean="springBean1" />
        <ref bean="springBean2" />
    </set>
</property>
</bean>
```
### [KomplexeBean.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/collections/KomplexeBean.java)
````java
public class KomplexeBean {

    private Properties emails;
    private List<String> kundenListe;
    private List<MeineBean> beanListe;
    private Map<String, MeineBean> beanMap;
    private Set<MeineBean> beanSet;


    public void sayHello() {

        System.out.println("Emails");
        System.out.println("\tchef:           " + emails.get("chef"));
        System.out.println("\tsous-chef:      " + emails.get("sous-chef"));
        System.out.println("\tsous-sous-chef: " + emails.get("sous-sous-chef"));

        System.out.println("Kundenliste:");
        kundenListe.forEach(System.out::println);
        System.out.println("\n");
        System.out.println("Beanliste welche die Referenzen auf die SpringBeans* hält");
        beanListe.forEach(MeineBean::sayHello);
        System.out.println("\n");
        System.out.println("BeanMap:");
        SpringBean1 springBean1 = (SpringBean1) beanMap.get("springBean1");
        springBean1.sayHello();
        SpringBean2 springBean2 = (SpringBean2) beanMap.get("springBean2");
        springBean2.sayHello();

        System.out.println("\n");
        System.out.println("BeanSet: ");
        beanSet.forEach(MeineBean::sayHello);

    }
}
````

### [KomplexeBeanRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/collections/KomplexeBeanRunner.java)
````java
ApplicationContext context = new ClassPathXmlApplicationContext("collections/collections.xml");
KomplexeBean bean = context.getBean(KomplexeBean.class);

bean.sayHello();
````

### output
````text
Emails
	chef:           chef@firlefanz.org
	sous-chef:      sour.chef@firlefanz.org
	sous-sous-chef: sous.sous.chef@firlefanz.org
Kundenliste:
Paperlapapp AG
Gibt es gar nicht Gmbh
Enterprise AG


Beanliste welche die Referenzen auf die SpringBeans* hält
Hello from SpringBean1
Hello from SpringBean2


BeanMap:
Hello from SpringBean1
Hello from SpringBean2


BeanSet: 
Hello from SpringBean1
Hello from SpringBean2
````

### [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
