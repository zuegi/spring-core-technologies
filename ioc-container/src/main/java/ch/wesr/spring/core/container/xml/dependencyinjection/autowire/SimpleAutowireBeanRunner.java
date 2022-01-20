package ch.wesr.spring.core.container.xml.dependencyinjection.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleAutowireBeanRunner {

    public static void main(String[] args) {
        // autowired="byName"
        System.out.println("autowired=\"byName\"");
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-by-name.xml");
        AutowireBean bean = context.getBean(AutowireBean.class);
        bean.sayHello();
        System.out.println("");

        // autowired="byType"
        System.out.println("autowired=\"byType\"");
        ApplicationContext contextByType = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-by-type.xml");
        AutowireBean beanByType = contextByType.getBean(AutowireBean.class);
        beanByType.sayHello();


        System.out.println("");
        // autowired="constructor"
        System.out.println("autowired=\"constructor\"");
        ApplicationContext contextConstructor = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-constructor.xml");
        AutowireConstructorBean autowireConstructorBean = contextConstructor.getBean(AutowireConstructorBean.class);
        autowireConstructorBean.sayHello();


        System.out.println("");
        // autowired="constructor"
        System.out.println("autowired=\"no\"");
        ApplicationContext contextNo = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-no.xml");
        AutowireBean autowireNoBean = contextNo.getBean(AutowireBean.class);
        autowireNoBean.sayHello();

    }
}
