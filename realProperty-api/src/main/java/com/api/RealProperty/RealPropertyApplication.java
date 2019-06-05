package com.api.RealProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
public class RealPropertyApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(RealPropertyApplication.class, args);
    }

}
