package ch.wesr.spring.core.container.annotation.javabased.containerconfig;

import ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean.SpringBean;
import ch.wesr.spring.core.container.annotation.javabased.containerconfig.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterContainerConfigurationRunner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        SpringBean bean = context.getBean(SpringBean.class);
        bean.sayHello();
    }
}
