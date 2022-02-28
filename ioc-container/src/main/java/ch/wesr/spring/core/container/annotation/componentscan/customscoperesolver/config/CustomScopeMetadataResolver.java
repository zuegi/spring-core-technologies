package ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class CustomScopeMetadataResolver implements ScopeMetadataResolver {

    public static final String MANDANT = "mandant";

    public CustomScopeMetadataResolver() {
    }

    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
        ScopeMetadata metadata = new ScopeMetadata();
        metadata.setScopeName(MANDANT);
        metadata.setScopedProxyMode(ScopedProxyMode.NO);
        return metadata;
    }
}
