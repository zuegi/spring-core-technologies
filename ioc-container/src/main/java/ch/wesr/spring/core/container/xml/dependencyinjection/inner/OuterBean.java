package ch.wesr.spring.core.container.xml.dependencyinjection.inner;

public class OuterBean {

    private InnerBean innerBean;

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        innerBean.sayHello();
    }

    public InnerBean getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }
}
