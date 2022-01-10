package ch.wesr.spring.core.container.xml.beans;

public class DefaultServiceLocator {
    private static ClientService clientService;
    private static SpringBeanService1 springBeanService1;

    public SpringBeanService1 erstelleSpringBeanService1() {
        springBeanService1 = new SpringBeanService1();
        return springBeanService1;
    }

    public ClientService erstelleClientService() {
        clientService = new ClientService();
        return clientService;
    }
}
