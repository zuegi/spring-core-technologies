package ch.wesr.spring.core.container.xml.dependencyinjection.collections;

import java.util.List;
import java.util.Properties;

public class KomplexeBean {

    private Properties emails;
    private List<String> kundenListe;
    private List<MeineBean> beanListe;

    public void sayHello() {

        System.out.println("Emails");
        System.out.println("\tchef:           "+emails.get("chef"));
        System.out.println("\tsous-chef:      "+emails.get("sous-chef"));
        System.out.println("\tsous-sous-chef: "+emails.get("sous-sous-chef"));

        System.out.println("Kundenliste:");
        kundenListe.forEach(System.out::println);
        System.out.println("\n");
        System.out.println("Beanliste welche die Referenzen auf die SpringBeans* hält");
        beanListe.forEach(MeineBean::sayHello);
    }

    public void setEmails(Properties emails) {
        this.emails = emails;
    }

    public Properties getEmails() {
        return emails;
    }

    public void setKundenListe(List kundenListe) {
        this.kundenListe = kundenListe;
    }

    public List getKundenListe() {
        return kundenListe;
    }

    public void setBeanListe(List beanListe) {
        this.beanListe = beanListe;
    }

    public List getBeanListe() {
        return beanListe;
    }
}
