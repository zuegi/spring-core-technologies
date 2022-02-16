package ch.wesr.spring.core.container.annotation.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AtValueRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SpringBean springBean = (SpringBean) context.getBean("springBean");
        springBean.sayHello();
    }
}
