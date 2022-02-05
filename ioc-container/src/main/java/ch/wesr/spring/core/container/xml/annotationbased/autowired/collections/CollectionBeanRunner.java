package ch.wesr.spring.core.container.xml.annotationbased.autowired.collections;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/collections/collections.xml");
        CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");

        collectionBean.sayHello();
    }
}
