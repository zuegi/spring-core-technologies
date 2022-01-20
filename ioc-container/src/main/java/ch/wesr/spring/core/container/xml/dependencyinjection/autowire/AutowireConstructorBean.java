package ch.wesr.spring.core.container.xml.dependencyinjection.autowire;

import ch.wesr.spring.core.container.xml.beans.SpringBean;

public class AutowireConstructorBean {

    private SpringBean springBean;

    public AutowireConstructorBean(SpringBean springBean) {
        this.springBean = springBean;
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getName());
        springBean.sayHello();
    }

    public SpringBean getSpringBean() {
        return springBean;
    }

    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }
}
