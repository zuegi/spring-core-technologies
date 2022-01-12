package ch.wesr.spring.core.container.xml.beans;

public class SetterBasedBean {

    // SetterBased Bean hat eine Dependency zu SpringBean
    private SpringBean springBean;

    // eine Setter Methode, sodass der Container die SpringBean injecten kann
    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
        System.out.println("springBean wurde gesetzt in "+this.getClass().getName());
    }

    public void sayHello() {
        springBean.sayHello();
    }
}
