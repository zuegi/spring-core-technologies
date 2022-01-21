package ch.wesr.spring.core.container.xml.dependencyinjection.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleAutowireCandidateBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-byname-autowire-candidate-false.xml");
        AutowireCandiateBean bean = context.getBean(AutowireCandiateBean.class);
        bean.sayHello();

        ApplicationContext context1 = new ClassPathXmlApplicationContext("dependencies/autowire/autowire-bytype-autowire-candidate-false.xml");
        AutowireCandiateBean bean1 = context1.getBean(AutowireCandiateBean.class);
        bean1.sayHello();
    }
}
