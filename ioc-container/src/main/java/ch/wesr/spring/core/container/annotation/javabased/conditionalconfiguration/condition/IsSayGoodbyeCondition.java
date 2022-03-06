package ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IsSayGoodbyeCondition implements ConfigurationCondition {
    public static final String GOODBYE_FROM = "goodbye from";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
       return context.getEnvironment().getProperty("sayAnything").equals(GOODBYE_FROM);
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.REGISTER_BEAN;
    }
}
