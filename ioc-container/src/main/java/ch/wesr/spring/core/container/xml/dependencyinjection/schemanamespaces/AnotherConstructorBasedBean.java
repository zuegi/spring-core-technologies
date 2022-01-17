package ch.wesr.spring.core.container.xml.dependencyinjection.schemanamespaces;

import ch.wesr.spring.core.container.xml.beans.SpringBean;
import ch.wesr.spring.core.container.xml.beans.SpringBean1;

public class AnotherConstructorBasedBean {


    private SpringBean springBean;
    private SpringBean1 springBean1;

    public AnotherConstructorBasedBean(SpringBean springBean, SpringBean1 springBean1) {
        this.springBean = springBean;
        this.springBean1 = springBean1;
    }

    public void sayHello() {
        System.out.println("\nHello from " +this.getClass().getSimpleName() +": ");
        springBean.sayHello();
        springBean1.sayHello();
    }
}
