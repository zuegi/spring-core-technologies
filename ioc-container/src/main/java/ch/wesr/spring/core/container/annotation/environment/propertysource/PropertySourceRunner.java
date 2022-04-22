package ch.wesr.spring.core.container.annotation.environment.propertysource;

import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class PropertySourceRunner {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // get Environment bean
        Environment env = (Environment) context.getBean("environment");
        // get SpringBean
        SpringBean springBean = (SpringBean) context.getBean("springBean");

        Assertions.assertThat(springBean.getName()).isEqualTo(env.getProperty("springbean.name"));
        Assertions.assertThat(springBean.getEnvironment()).isEqualTo(env.getProperty("springbean.environment"));
        Assertions.assertThat(springBean.getModule()).isEqualTo(env.getProperty("springbean.module"));

        System.out.println("hello from " +springBean.getName());
    }

}
