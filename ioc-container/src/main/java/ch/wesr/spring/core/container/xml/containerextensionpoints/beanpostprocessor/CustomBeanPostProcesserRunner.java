package ch.wesr.spring.core.container.xml.containerextensionpoints.beanpostprocessor;

import ch.wesr.spring.core.container.xml.containerextensionpoints.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomBeanPostProcesserRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/containerextensionpoints/bean-post-processor.xml");
        context.registerShutdownHook();
        SpringBean springBean = (SpringBean) context.getBean("springBean");
        springBean.sayHello();

//        SpringBean2 springBean2 = (SpringBean2) context.getBean("springBean2");
//        springBean2.sayHello();

        System.out.println("8. Wenn der Container heruntergefahren wird, werden die  Destory Callback Methoden aufgerufen");
    }
}
