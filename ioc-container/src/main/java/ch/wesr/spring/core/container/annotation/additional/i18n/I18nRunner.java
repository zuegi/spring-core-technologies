package ch.wesr.spring.core.container.annotation.additional.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class I18nRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("lang/lang");


        System.out.println(messageSource.getMessage("hello", null, Locale.ITALIAN));
        System.out.println(messageSource.getMessage("welcome", new Object[]{"Bruno"}, Locale.ITALIAN));

        System.out.println(messageSource.getMessage("hello", null, Locale.GERMAN));
        System.out.println(messageSource.getMessage("welcome", new Object[]{"Wolfgang"}, Locale.GERMAN));

        System.out.println(messageSource.getMessage("hello", null, Locale.ENGLISH));
        System.out.println(messageSource.getMessage("welcome", new Object[]{"Paul"}, Locale.ENGLISH));

    }
}
