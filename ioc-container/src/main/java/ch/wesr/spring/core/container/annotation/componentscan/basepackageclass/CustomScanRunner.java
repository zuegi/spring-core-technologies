package ch.wesr.spring.core.container.annotation.componentscan.basepackageclass;

import ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.client.ClientBean;
import ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.config.AppConfig;
import ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.service.ServiceBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomScanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientBean bean = context.getBean(ClientBean.class);
        bean.sayHello();

        ServiceBean serviceBean = context.getBean(ServiceBean.class);
        serviceBean.sayHello();
    }
}
