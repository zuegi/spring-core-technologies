package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean implements InitializingBean, DisposableBean, BeanNameAware {

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
        System.out.println("5.1. Mit @PostConstruct annotierte Mehode");
        System.out.println("\t" +this.getClass().getSimpleName() +".sayPostConstructHello(): aufgerufen weil mit @PostConstruct annotiert");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.2. InitializingBean.afterSetProperties()");
        System.out.println("\t" +this.getClass().getSimpleName() + ".afterPropertiesSet(): aufgerufen aus dem InitializingBean");
    }

    public void customBeanInit() {
        System.out.println("5.3. Setter Methode über das Bean Definition Attribut init-method=\"customBeanInit()\"");
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
