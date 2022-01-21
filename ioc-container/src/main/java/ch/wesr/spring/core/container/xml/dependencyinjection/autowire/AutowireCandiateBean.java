package ch.wesr.spring.core.container.xml.dependencyinjection.autowire;

import ch.wesr.spring.core.container.xml.beans.SpringBean;
import ch.wesr.spring.core.container.xml.beans.SpringBean1;

public class AutowireCandiateBean {

    SpringBean springBean;
    SpringBean1 springBean1;

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
        springBean.sayHello();
        springBean1.sayHello();
    }

    public SpringBean getSpringBean() {
        return springBean;
    }

    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }

    public SpringBean1 getSpringBean1() {
        return springBean1;
    }

    public void setSpringBean1(SpringBean1 springBean1) {
        this.springBean1 = springBean1;
    }
}
