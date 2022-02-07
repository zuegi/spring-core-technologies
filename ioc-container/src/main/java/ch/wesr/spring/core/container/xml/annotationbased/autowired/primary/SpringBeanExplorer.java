package ch.wesr.spring.core.container.xml.annotationbased.autowired.primary;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanExplorer {

    @Autowired
    private SpringBean springBean;

    public void explore() {
        springBean.sayHello();
    }
}
