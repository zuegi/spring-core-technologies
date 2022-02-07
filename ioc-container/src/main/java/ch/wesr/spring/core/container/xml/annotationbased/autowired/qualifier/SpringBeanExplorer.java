package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SpringBeanExplorer {

    @Autowired
    @Qualifier("primary")
    private SpringBean springBean;


    public void explore() {
        springBean.sayHello();
    }
}
