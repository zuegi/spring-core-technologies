package ch.wesr.spring.core.container.annotation.javabased.conditionalbean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IsToSayHelloCondition implements Condition {

    public static final String HELLO_FROM = "hello from";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("sayAnything").equals(HELLO_FROM);
    }
}
