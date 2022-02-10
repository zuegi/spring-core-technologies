package ch.wesr.spring.core.container.annotation.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ResourcesInjectionRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SpringBeanExplorer springBeanExplorer = (SpringBeanExplorer) context.getBean("springBeanExplorer");
        springBeanExplorer.explore();
    }
}
