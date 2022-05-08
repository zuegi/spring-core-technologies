package ch.wesr.spring.core.resources;

import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.io.IOException;

public class ResourceLoaderRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ResourceLoaderService loaderService = context.getBean(ResourceLoaderService.class);

        try {
            Assertions.assertThat(loaderService.zeigeResourceDataMitFilePath()).contains("= 2 Resources");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Assertions.assertThat(loaderService.zeigeResourceAusDemClasspath()).contains("hallo ich bin der Inhalt eines hallo.txt files aus dem classpath");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
