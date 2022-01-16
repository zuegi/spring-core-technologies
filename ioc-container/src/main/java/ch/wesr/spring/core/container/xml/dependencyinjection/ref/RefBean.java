package ch.wesr.spring.core.container.xml.dependencyinjection.ref;

import ch.wesr.spring.core.container.xml.beans.SpringBean;

public class RefBean {

    private SpringBean justAnotherBean;

    public SpringBean getJustAnotherBean() {
        return justAnotherBean;
    }

    public void setJustAnotherBean(SpringBean justAnotherBean) {
        this.justAnotherBean = justAnotherBean;
    }

    public void sayHello() {
        System.out.println(this.getClass().getName());
        justAnotherBean.sayHello();
    }
}
