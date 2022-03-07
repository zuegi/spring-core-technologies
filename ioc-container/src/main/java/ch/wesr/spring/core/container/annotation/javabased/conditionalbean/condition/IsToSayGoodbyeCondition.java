package ch.wesr.spring.core.container.annotation.javabased.conditionalbean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IsToSayGoodbyeCondition implements Condition {

    public static final String GOODBYE_FROM = "goodbye from";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("sayAnything").equals(GOODBYE_FROM);
    }
}
