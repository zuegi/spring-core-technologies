package ch.wesr.spring.core.container.xml.dependencyinjection.compoundpropertynames;

public class CompoundPropertyNamesBean {

    private SpringBeanFred fred;

    public SpringBeanFred getFred() {
        return fred;
    }

    public void setFred(SpringBeanFred fred) {
        this.fred = fred;
    }

    public void sayHello() {
        System.out.println("Sam ist " + fred.getBob().getSam().getAge() + " Jahre alt");
    }
}
