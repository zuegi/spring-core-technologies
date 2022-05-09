package ch.wesr.spring.core.resources;

import org.assertj.core.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.io.IOException;

public class ResourceLoaderRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ResourceLoaderService loaderService = context.getBean(ResourceLoaderService.class);
        // lies aus einer FilePath Resource
        try {
            Assertions.assertThat(loaderService.zeigeResourceDataMitFilePath()).contains("= 2 Resources");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        lies aus einer classpath resource
        try {
            Assertions.assertThat(loaderService.zeigeResourceAusDemClasspath()).contains("hallo ich bin der Inhalt eines hallo.txt files aus dem classpath");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // lies aus einer http resource
        try {
            Assertions.assertThat(loaderService.zeigeResourcesAusWebSeite()).contains("Climate STABIO");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
