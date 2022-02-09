package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomAutowireConfigurerRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/custom-autowire-configurer.xml");
        SpringBeanExplorer bean = context.getBean(SpringBeanExplorer.class);
        bean.explore();
    }
}
