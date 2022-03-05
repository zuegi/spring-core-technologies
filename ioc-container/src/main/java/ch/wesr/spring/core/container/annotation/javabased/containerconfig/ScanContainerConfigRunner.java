package ch.wesr.spring.core.container.annotation.javabased.containerconfig;

import ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean.ScannedSpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanContainerConfigRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean");
        context.refresh();
        ScannedSpringBean bean = context.getBean(ScannedSpringBean.class);
        bean.sayHello();
    }
}
