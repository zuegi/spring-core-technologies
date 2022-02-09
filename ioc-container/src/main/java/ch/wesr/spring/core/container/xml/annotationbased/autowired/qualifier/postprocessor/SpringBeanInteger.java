package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.postprocessor;

public class SpringBeanInteger implements SpringBean {
    private Integer zahl;

    @Override
    public void sayHello() {
        System.out.println("Hello with zahl: " +zahl);
    }

    public Integer getZahl() {
        return zahl;
    }

    public void setZahl(Integer zahl) {
        this.zahl = zahl;
    }
}
