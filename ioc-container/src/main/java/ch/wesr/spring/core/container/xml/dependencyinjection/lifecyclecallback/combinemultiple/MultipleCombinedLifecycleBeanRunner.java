package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.combinemultiple;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultipleCombinedLifecycleBeanRunner {

    public static void main(String[] args) {
        System.out.println("Initialsiere den Spring Container");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/combine-multiple-lifecycle.xml");
        SpringBean bean = context.getBean(SpringBean.class);


        System.out.println("\nShutdown des Spring Container");
        context.close();

    }
}
