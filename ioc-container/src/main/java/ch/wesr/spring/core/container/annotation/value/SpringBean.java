package ch.wesr.spring.core.container.annotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class SpringBean {

    @Value("${app.author.name}")
    private String name;

    @Value("${app.author.name}")
    private final String firstName;


    @Value("#{'${app.author.hobbies}'.split(',')}")
    private String[] hobbies;

    @Value("#{systemEnvironment['my-prop']}")
    private String myProp;

    @Value("#{systemProperties['my-option']}")
    private String myOption;

    @Value("#{systemProperties['another-propt'] ?: 'kein anderes Property gesetzt'}")
    private String anotherProp;

    @Value("#{${valuesMap}}")
    private Map<String, String> valuesMap;

    @Value("#{${valuesMap}.?[value.equals('Tokio')]}")
    private Map<String, String> valuesMapFiltered;

    public SpringBean(@Value("${app.author.firstname}")String firstName) {
        this.firstName = firstName;
    }

    public void sayHello() {
        System.out.println("Hello " +firstName +" " +name + " from " +this.getClass().getSimpleName());
        System.out.println("Deine Hobbies sind:" + Arrays.toString(hobbies));
        System.out.println("\tenvironment var my-prop: " + myProp);
        System.out.println("\tsytemproperty my-option: " + myOption);
        System.out.println("\tsytemproperty another-prop: " + anotherProp);
        System.out.println(Arrays.asList(valuesMap));
        System.out.println(Arrays.asList(valuesMapFiltered));
    }
}
