package ch.wesr.spring.core.container.annotation.environment.propertysource;

import lombok.Data;

@Data
public class SpringBean {

    private String name;
    private String environment;
    private String module;

}
