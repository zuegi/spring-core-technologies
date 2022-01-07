package ch.wesr.spring.core.container.xml;

import ch.wesr.spring.core.container.xml.beans.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FileSystemXmlApplicationContextRunner {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("/config/filesystem-bean-config.xml");

        SpringBean springBean = context.getBean(SpringBean.class);
        springBean.sayHello();;
    }
}
