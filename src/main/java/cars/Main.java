package cars;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
           .configure("hibernate.cfg.xml")
            .build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}