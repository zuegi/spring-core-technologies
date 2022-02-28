package ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.config;

import ch.wesr.spring.core.container.annotation.componentscan.customscope.scope.MandantScope;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import static ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.config.CustomScopeMetadataResolver.MANDANT;

public class MandantBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerScope(MANDANT, new MandantScope());
    }
}
