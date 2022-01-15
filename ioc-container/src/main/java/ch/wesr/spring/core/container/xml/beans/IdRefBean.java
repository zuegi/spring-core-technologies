package ch.wesr.spring.core.container.xml.beans;

public class IdRefBean {

   String irgendEinString;

    public void sayHello() {
        System.out.println("Das ist die Bean als String: " +irgendEinString);
    }

    public String getIrgendEinString() {
        return irgendEinString;
    }

    public void setIrgendEinString(String irgendEinString) {
        this.irgendEinString = irgendEinString;
    }
}
