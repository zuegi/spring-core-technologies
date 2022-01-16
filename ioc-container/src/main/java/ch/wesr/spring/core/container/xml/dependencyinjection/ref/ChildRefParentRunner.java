package ch.wesr.spring.core.container.xml.dependencyinjection.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChildRefParentRunner {

    public static void main(String[] args) {
        ApplicationContext parent = new ClassPathXmlApplicationContext("ref/parent-ref.xml");

        ApplicationContext child = new ClassPathXmlApplicationContext(parent);

        ChildBean bean = child.getBean(ChildBean.class);
        bean.sayHello();


    }
}
