package ch.wesr.spring.core.container.xml.dependencyinjection.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParentRefRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ref/parent-ref.xml");

//        RefBean bean = context.getBean(RefBean.class);
//        bean.sayHello();
    }
}
