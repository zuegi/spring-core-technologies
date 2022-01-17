package ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames;

public class SpringBeanFred {

    private SpringBeanBob bob;

    public SpringBeanBob getBob() {
        return bob;
    }

    public void setBob(SpringBeanBob bob) {
        this.bob = bob;
    }
}
