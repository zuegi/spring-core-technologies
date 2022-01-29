package ch.wesr.spring.core.container.xml.beaninheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleBeanInheritanceRunner {

    public static void main(String[] args) {
        System.out.println("Spring Bean Definition Inheritance ohne Template (BaseBean)");
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/inheritance/bean-definition-inheritance.xml");
        SpringBean springBean = (SpringBean) context.getBean("springBean");

        springBean.sayHello();


        System.out.println("Spring Bean Definition Inheritance mit Template (AbstractBaseBean)");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("dependencies/inheritance/abstract-bean-definition-inheritance.xml");
        SpringBean springBean2 = (SpringBean) context.getBean("springBean");

        springBean2.sayHello();
    }
}
