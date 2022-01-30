package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean implements InitializingBean, DisposableBean {


    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }

    @PostConstruct
    public void sayPostConstructHello() {
        System.out.println(this.getClass().getSimpleName() +".sayPostConstructHello(): aufgerufen weil mit @PostConstruct annotiert");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ".afterPropertiesSet(): aufgerufen aus dem InitializingBean");
    }

    public void customBeanInit() {
        System.out.println(this.getClass().getSimpleName() + ".customBeanInit(): aufgerufen über das Bean Defintion Attribut init-method customBeanInit() ");
    }


    @PreDestroy
    public void sayPreDestroyGoodBy() {
        System.out.println(this.getClass().getSimpleName() + ".sayPreDestroyGoodBy(): aufgerufen weil mit @PreDestory annotiert");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ".destroy(): aufgerufen  aus dem DisposableBean");
    }

    public void customBeanDestroy() {
        System.out.println(this.getClass().getSimpleName() + ".customBeanDestroy(): aufgerufen über das Bean Definition Atrribut destroy-method customBeanDestry() ");
    }
}
