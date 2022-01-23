package ch.wesr.spring.core.container.xml.dependencyinjection.methodinjection;

public class PrototypeBean {
    private String message;

    public PrototypeBean() {
        System.out.println("Prototype Bean Instantiated !!");
    }

    public void sayHello(String variableName) {
        System.out.println("Ich bin das Bean: " +variableName);
        System.out.println("\tobject: " +this);
        System.out.println("\tmessage: " +this.getMessage());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
