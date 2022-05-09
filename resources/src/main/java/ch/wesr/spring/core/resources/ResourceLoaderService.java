package ch.wesr.spring.core.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.Resources;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class ResourceLoaderService {

    @Autowired
    ResourceLoader resourceLoader;

    public String zeigeResourceDataMitFilePath() throws IOException {
        Resource resource = resourceLoader.getResource("file:/Users/groot/WS/SpringProfessionalExam/spring-core-technologies/resources/resources.adoc");
        return getStringFromResource(resource);
    }

    private String getStringFromResource(Resource resource) throws IOException {
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        reader.close();
        assert stringBuilder != null;
        return stringBuilder.toString();
    }

    public String zeigeResourceAusDemClasspath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:hallo.txt");
        return getStringFromResource(resource);
    }

    public String zeigeResourcesAusWebSeite() throws IOException {
        Resource resource = resourceLoader.getResource("https://en.tutiempo.net/climate/ws-67710.html");
        return getStringFromResource(resource);
    }
}
