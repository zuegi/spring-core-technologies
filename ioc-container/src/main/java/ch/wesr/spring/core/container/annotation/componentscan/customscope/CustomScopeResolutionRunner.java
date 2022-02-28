package ch.wesr.spring.core.container.annotation.componentscan.customscope;

import ch.wesr.spring.core.container.annotation.componentscan.customscope.bean.MandantBean;
import ch.wesr.spring.core.container.annotation.componentscan.customscope.config.AppConfig;
import ch.wesr.spring.core.container.annotation.componentscan.customscope.scope.MandantScope;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomScopeResolutionRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig")
                        && !bean.contains("beanFactoryPostProcessor"))
                .collect(Collectors.toList());
        assertThat(beans)
                .hasSize(2)
                .containsExactlyInAnyOrder("bar", "foo");

        MandantBean bar = (MandantBean) context.getBean("bar");
        bar.sayHello();
        MandantBean foo = (MandantBean) context.getBean("foo");
        foo.sayHello();

        String fooScope = context.getBeanFactory().getBeanDefinition("foo").getScope();
        assertThat(fooScope).isEqualTo(MandantScope.MANDANT);
        String barScope = context.getBeanFactory().getBeanDefinition("bar").getScope();
        assertThat(barScope).isEqualTo(MandantScope.MANDANT);

    }
}
