package ch.wesr.spring.core.container.annotation.javabased.litebeans;

import ch.wesr.spring.core.container.annotation.javabased.litebeans.componentbeans.ComponentBean1;
import ch.wesr.spring.core.container.annotation.javabased.litebeans.beans.ConfigurationBean1;
import ch.wesr.spring.core.container.annotation.javabased.litebeans.config.AppConfig;
import ch.wesr.spring.core.container.annotation.javabased.litebeans.config.AppComponent;
import org.assertj.core.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LiteBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(2)
                .containsExactly("configurationBean1", "configurationBean2");

        ConfigurationBean1 bean = context.getBean(ConfigurationBean1.class);
        bean.sayHello();
        System.out.println("Singleton - wird immer dasselbe Bean aufrufen");
        bean.sayHello();

        System.out.println("*****************************************");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppComponent.class);

        List<String> componentBeans = Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(componentBean -> !componentBean.contains("org.springframework")
                        && !componentBean.contains("appComponent"))
                .collect(Collectors.toList());
        Assertions.assertThat(componentBeans)
                .hasSize(2)
                .containsExactly("componentBean1", "name");

        ComponentBean1 componentBean1 = ctx.getBean(ComponentBean1.class);
        componentBean1.sayHello();
        System.out.println(componentBean1.hashCode());
    }
}
