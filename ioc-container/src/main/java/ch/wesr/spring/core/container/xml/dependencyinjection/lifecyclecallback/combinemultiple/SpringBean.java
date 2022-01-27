package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.combinemultiple;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean implements InitializingBean, DisposableBean {

    @PostConstruct
    public void sayHello() {
        System.out.println(this.getClass().getSimpleName() +": aufgerufen über die mit @PostConstruct annotierte Methode sayHello()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die  afterPropertiesSet() aus dem InitializingBean");
    }

    public void customBeanInit() {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die custom method customBeanInit() ");
    }


    @PreDestroy
    public void sayGoodBy() {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die mit @PreDestory annotierte Methode sayGoodBy()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen  über die  destory() Methode  aus dem DisposableBean");
    }

    public void customBeanDestroy() {
        System.out.println(this.getClass().getSimpleName() + ": aufgerufen über die custom method customBeanDestry() ");
    }
}
