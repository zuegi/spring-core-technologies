package ch.wesr.spring.core.container.xml.annotationbased.autowired;


import lombok.ToString;

@ToString
public class SpringBean {

    private String objectName;
    private String klasse;

    public void sayHello() {
        System.out.println(this);
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

}
