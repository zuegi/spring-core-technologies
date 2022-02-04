package ch.wesr.spring.core.container.xml.annotationbased;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanExplorer {

//    @Autowired
    private SpringBean springBean;

    public void explore() {
        springBean.setKlasse(springBean.getClass().getSimpleName());
        springBean.setObjectName("springBean");
        springBean.sayHello();
    }

    public SpringBean getSpringBean() {
        return springBean;
    }

    @Autowired
    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }
}
