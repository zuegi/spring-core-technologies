package ch.wesr.spring.core.container.xml.beans;

public class ConstructorBasedBean {

    private SpringBean springBean;
    private SpringBean1 springBean1;

    public ConstructorBasedBean(SpringBean springBean, SpringBean1 springBean1) {
        this.springBean = springBean;
        this.springBean1 = springBean1;
    }

    public void sayHello() {
        springBean.sayHello();
        springBean1.sayHello();
    }
}
