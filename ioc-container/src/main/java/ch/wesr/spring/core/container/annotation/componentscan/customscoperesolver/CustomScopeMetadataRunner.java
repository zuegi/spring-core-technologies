package ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver;

import ch.wesr.spring.core.container.annotation.componentscan.customscope.scope.MandantScope;
import ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.bean.MandantBean;
import ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.config.AppConfig;
import ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.config.CustomScopeMetadataResolver;
import org.assertj.core.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomScopeMetadataRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        List<String> beans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("appConfig")
                        && !bean.contains("customScopeMetadataResolver"))
                .collect(Collectors.toList());
        Assertions.assertThat(beans)
                .hasSize(2)
                .containsExactlyInAnyOrder("bar", "foo");

        MandantBean bar = (MandantBean) context.getBean("bar");
        bar.sayHello();
        MandantBean foo = (MandantBean) context.getBean("foo");
        foo.sayHello();


        String fooScope = context.getBeanFactory().getBeanDefinition("foo").getScope();
        assertThat(fooScope).isEqualTo(CustomScopeMetadataResolver.MANDANT);
        String barScope = context.getBeanFactory().getBeanDefinition("bar").getScope();
        assertThat(barScope).isEqualTo(CustomScopeMetadataResolver.MANDANT);
    }
}
