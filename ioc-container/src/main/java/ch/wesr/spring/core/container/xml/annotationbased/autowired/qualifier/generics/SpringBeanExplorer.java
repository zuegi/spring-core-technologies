package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.generics;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanExplorer {

    @Autowired
    private GenericsQualifier<String> springbeanString;

    @Autowired
    private GenericsQualifier<Integer> springBeanInteger;

    public void explore() {
        springbeanString.sayHello();
        springBeanInteger.sayHello();
    }
}
