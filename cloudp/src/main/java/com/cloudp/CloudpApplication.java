package com.cloudp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cloudp.*"})
@SpringBootApplication
public class CloudpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudpApplication.class, args);
    }

}
