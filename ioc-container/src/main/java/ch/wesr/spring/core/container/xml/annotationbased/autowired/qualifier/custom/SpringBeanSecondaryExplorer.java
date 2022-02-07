package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.custom;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanSecondaryExplorer {

    @Autowired
   @SecondaryQualifier
    private SpringBean springBean;

    public void explore() {
        springBean.sayHello();
    }

}
