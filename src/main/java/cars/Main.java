package cars;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()

@ComponentScan("cars")
@EntityScan("cars.entity")
@EnableJpaRepositories("cars.repository")
public class Main  {


    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }
}