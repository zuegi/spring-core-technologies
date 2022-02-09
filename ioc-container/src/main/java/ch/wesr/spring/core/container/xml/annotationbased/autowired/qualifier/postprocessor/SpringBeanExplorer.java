package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.postprocessor;


import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanExplorer {

    @Autowired
    @StringQualifier
    private SpringBean springBean;

    @Autowired
    @IntegerQualifier
    private SpringBean intBean;


    public void explore() {
        springBean.sayHello();
        intBean.sayHello();
    }
}
