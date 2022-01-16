package ch.wesr.spring.core.container.xml.dependencyinjection.inner;

public class ConstructorArgOuterBean {

    private InnerBean innerBean;

    public ConstructorArgOuterBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        innerBean.sayHello();
    }
}
