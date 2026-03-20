package cydrownia.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("cydrownia.model")
@SpringBootApplication(scanBasePackages = "cydrownia")
@EnableJpaRepositories(basePackages = "cydrownia.repository.data")
public class CydrowniaServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(CydrowniaServiceMain.class, args);
    }
}