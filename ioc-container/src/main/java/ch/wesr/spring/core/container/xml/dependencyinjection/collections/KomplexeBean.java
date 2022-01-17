package ch.wesr.spring.core.container.xml.dependencyinjection.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class KomplexeBean {

    private Properties emails;
    private List<String> kundenListe;
    private List<MeineBean> beanListe;
    private Map<String, MeineBean> beanMap;
    private Set<MeineBean> beanSet;


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
        System.out.println("\n");
        System.out.println("BeanMap:");
        SpringBean1 springBean1 = (SpringBean1) beanMap.get("springBean1");
        springBean1.sayHello();
        SpringBean2 springBean2 = (SpringBean2) beanMap.get("springBean2");
        springBean2.sayHello();

        System.out.println("\n");
        System.out.println("BeanSet: ");
        beanSet.forEach(MeineBean::sayHello);

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

    public void setBeanMap(Map<String, MeineBean> beanMap) {
        this.beanMap = beanMap;
    }

    public Map<String, MeineBean> getBeanMap() {
        return beanMap;
    }

    public void setBeanSet(Set<MeineBean> beanSet) {
        this.beanSet = beanSet;
    }

    public Set<MeineBean> getBeanSet() {
        return beanSet;
    }
}
