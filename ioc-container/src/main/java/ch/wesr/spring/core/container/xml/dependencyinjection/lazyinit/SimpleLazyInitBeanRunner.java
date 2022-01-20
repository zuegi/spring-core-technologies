package ch.wesr.spring.core.container.xml.dependencyinjection.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleLazyInitBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lazyinit/lazy-init.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("Vorhandene Bean: "+ beanDefinitionName);
        }

        LazyInitBean bean = context.getBean(LazyInitBean.class);
        if (bean == null) {
            System.out.println("LazyInitbean ist noch nicht erstellt/initialisiert");
        }

    }
}
