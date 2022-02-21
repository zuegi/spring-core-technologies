package ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation;

import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.config.AppConfig;
import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.explore.BeanExplorer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationFilterTypeRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanExplorer bean = context.getBean(BeanExplorer.class);
        bean.explore();
    }
}
