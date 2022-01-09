package ch.wesr.spring.core.container.xml;

import ch.wesr.spring.core.container.xml.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Die Packages org.springframework.context und org.springframework.beans
 * gehören zur Basis des IoC (Inversion of Control / Dependency Injection) Container des Springframework
 *
 *  @author wesr
 *  @version 0.1
 *  @since   2022-01-07
 */
public class ClassPathXmlApplicationContextRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

        SpringBean springBean = context.getBean(SpringBean.class);
        springBean.sayHello();

        SpringBean1 customBean1 = (SpringBean1) context.getBean("customBean1");
        customBean1.sayHelloFrom();

        SpringBean2 springBean2 = context.getBean(SpringBean2.class);
        springBean2.sayHello();

        SpringBean3 springBean3 = (SpringBean3) context.getBean("spring-Bean$3");
        springBean3.sayHello();

        SpringBean4 springBean4 = (SpringBean4) context.getBean("$$*ç%");
        springBean4.sayHello();

        SpringBean5 springBean5 = (SpringBean5) context.getBean("%ç*$$");
        springBean5.sayHello();

        SpringBean1 subsystemACustomBean1 = (SpringBean1) context.getBean("subsystemA-customBean1");
        subsystemACustomBean1.sayHelloFrom();

        SpringBean1 subsystemBCustomBean1 = (SpringBean1) context.getBean("subsystemB-customBean1");
        subsystemBCustomBean1.sayHelloFrom();



    }
}
