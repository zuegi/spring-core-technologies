package ch.wesr.spring.core.container.annotation.javabased.litebeans.beans;

public class ConfigurationBean1 {

    private ConfigurationBean2 configurationBean2;

    public ConfigurationBean1(ConfigurationBean2 configurationBean2) {
        this.configurationBean2 = configurationBean2;
    }

    public ConfigurationBean2 getConfigurationBean2() {
        return configurationBean2;
    }

    public void setConfigurationBean2(ConfigurationBean2 configurationBean2) {
        this.configurationBean2 = configurationBean2;
    }

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName() +": " +this);
        configurationBean2.sayHello();
    }

    private void init() {
        System.out.println("Created Bean: " +this.getClass().getSimpleName());
    }
}
