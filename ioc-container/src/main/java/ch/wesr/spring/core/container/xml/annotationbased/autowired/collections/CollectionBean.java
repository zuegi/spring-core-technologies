package ch.wesr.spring.core.container.xml.annotationbased.autowired.collections;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CollectionBean {

    @Autowired
    private Properties emails;
    @Autowired
    private List<MeineBean> beanListe;
    @Autowired
    private HashMap<String, MeineBean> beanMap;
    @Autowired
    private Set<MeineBean> beanSet;

    @Autowired
    private SpringBean1 springBean1;

    @Autowired
    SpringBean2 springBean2;

    public void sayHello() {
        System.out.println("Emails");
        System.out.println("\tchef:           "+emails.get("chef"));
        System.out.println("\tsous-chef:      "+emails.get("sous-chef"));
        System.out.println("\tsous-sous-chef: "+emails.get("sous-sous-chef"));

        System.out.println("\n");
        System.out.println("Beanliste welche die Referenzen auf die SpringBeans* hält");
        beanListe.forEach(MeineBean::sayHello);
        System.out.println("\n");
        System.out.println("BeanMap:");
        springBean1 = (SpringBean1) beanMap.get("springBean1");
        springBean1.sayHello();
        springBean2 = (SpringBean2) beanMap.get("springBean2");
        springBean2.sayHello();

        System.out.println("\n");
        System.out.println("BeanSet: ");
        beanSet.forEach(MeineBean::sayHello);
    }

    public Properties getEmails() {
        return emails;
    }

    public void setEmails(Properties emails) {
        this.emails = emails;
    }

    public List<MeineBean> getBeanListe() {
        return beanListe;
    }

    public void setBeanListe(List<MeineBean> beanListe) {
        this.beanListe = beanListe;
    }

    public Map<String, MeineBean> getBeanMap() {
        return beanMap;
    }

    public void setBeanMap(HashMap<String, MeineBean> beanMap) {
        this.beanMap = beanMap;
    }

    public Set<MeineBean> getBeanSet() {
        return beanSet;
    }

    public void setBeanSet(Set<MeineBean> beanSet) {
        this.beanSet = beanSet;
    }
}
