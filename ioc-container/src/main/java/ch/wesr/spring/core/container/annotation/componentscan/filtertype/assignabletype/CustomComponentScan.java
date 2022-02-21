package ch.wesr.spring.core.container.annotation.componentscan.filtertype.assignabletype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomComponentScan {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringBean bean = context.getBean(SpringBean.class);
        bean.sayHello();
    }
}
