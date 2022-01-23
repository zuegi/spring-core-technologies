package ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection;

abstract class AbstractSingletonBean {

    public AbstractSingletonBean() {
        System.out.println("Abstract Singleton Bean instantiated !!");
    }

    public abstract PrototypeBean getPrototypeBean();
}
