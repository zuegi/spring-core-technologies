package ch.wesr.spring.core.container.xml.beans;

public class BasicDataSource {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private SpringBean springBean;

    public void sayHello() {
        System.out.println("Hello "+getUsername() +", du verbindest dich mit " +getUrl());
        springBean.sayHello();
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SpringBean getSpringBean() {
        return springBean;
    }

    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }
}
