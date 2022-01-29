package ch.wesr.spring.core.container.xml.beaninheritance;

public class BaseSpringBean {

    private String name;
    private String baseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
