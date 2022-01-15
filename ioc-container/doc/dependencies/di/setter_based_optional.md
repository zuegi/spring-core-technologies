# Setter based optional
Die **Setter-based** Variante sollte vor allem für optionale Abhängigkeiten, welche im Sinne einer Konfiguration verwendet,
gesetzt werden. Dabei muss beachtet werden, dass bei Verwendung der optionale Abhängigkeit immer ein **null-check**
gemacht werden muss, bevor die Abhängigkeit verwendet wird.
````xml

<bean id="springBean" class="ch.wesr.spring.core.container.xml.beans.SpringBean"/>
<bean id="setterBasedBean" class="ch.wesr.spring.core.container.xml.beans.SetterBasedBean">
<!-- Die springBean wird zwar deklariert, aber nicht als Referenz der setterbaseBean übergeben -->
</bean>
````

````java
public class SetterBasedBean {

    // SetterBased Bean hat eine Dependency zu SpringBean
    private SpringBean springBean;

    // eine Setter Methode, sodass der Container die SpringBean injecten kann
    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
        System.out.println("springBean wurde gesetzt in "+this.getClass().getName());
    }

    public void sayHello() {
        Objects.requireNonNull(springBean, "Achtung! Wenn die SpringBean optional verwendet wird, muss sie auf null-check geprüft werden.").sayHello();
    }
}
````
Der entsprechende Aufruf

````java
public class SimpleSetterOptionalDIRunner {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("setterbased/setter-based-optional.xml");

    SetterBasedBean bean = context.getBean(SetterBasedBean.class);
    bean.sayHello();
  }
}
````
resultiert dann in einer Null-Pointer Exception
````text
Exception in thread "main" java.lang.NullPointerException: Achtung! Wenn die SpringBean optional verwendet wird, muss sie auf null-check geprüft werden.
	at java.base/java.util.Objects.requireNonNull(Objects.java:247)
	at ch.wesr.spring.core.container.xml.beans.SetterBasedBean.sayHello(SetterBasedBean.java:17)
	at ch.wesr.spring.core.container.xml.dependencyinjection.setterbased.SimpleSetterOptionalDIRunner.main(SimpleSetterOptionalDIRunner.java:13)
````

Code Beispiel [SimpleSetterOptionalDIRunner.java](../../../src/main/java/ch/wesr/spring/core/container/xml/dependencyinjection/setterbased/SimpleSetterOptionalDIRunner.java)

#Frage: Wie kann ich zur Laufzeit entscheiden ob der Setter injected werden soll oder nicht?

###[zurück zu spring-ioc-container](../../../spring-ioc-container.md)
