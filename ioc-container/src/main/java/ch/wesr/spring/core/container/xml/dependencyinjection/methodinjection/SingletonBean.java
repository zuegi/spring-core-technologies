package ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection;

public class SingletonBean {
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        System.out.println("Singleton Bean Instantiated !!");
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }

    public void setPrototypeBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
