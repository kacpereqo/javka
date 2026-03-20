package cydrownia.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("cydrownia.model")
@SpringBootApplication(scanBasePackages = "cydrownia")
public class CydrowniaServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(CydrowniaServiceMain.class, args);
    }
}