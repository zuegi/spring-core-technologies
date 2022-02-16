package ch.wesr.spring.core.container.xml.annotationbased.value;

import java.util.Arrays;

public class SpringBean {

    private String name;
    private String firstName;
    private String[] hobbies;
    private String myProp;
    private String myOption;
    private String anotherProp;

    public SpringBean(String firstName) {
        this.firstName = firstName;
    }

    public void sayHello() {
        System.out.println("Hello " +firstName +" " +name + " from " +this.getClass().getSimpleName());
        System.out.println("Deine Hobbies sind:" +Arrays.toString(hobbies));
        System.out.println("\tenvironment var my-prop: " + myProp);
        System.out.println("\tsytemproperty my-option: " + myOption);
        System.out.println("\tsytemproperty another-prop: " + anotherProp);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyProp() {
        return myProp;
    }

    public void setMyProp(String myProp) {
        this.myProp = myProp;
    }

    public void setMyOption(String myOption) {
        this.myOption = myOption;
    }

    public String getMyOption() {
        return myOption;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setAnotherProp(String anotherProp) {
        this.anotherProp = anotherProp;
    }

    public String getAnotherProp() {
        return anotherProp;
    }
}
