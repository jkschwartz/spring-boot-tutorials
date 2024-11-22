package com.baeldung.springbootreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootReactApplication {
    public static void main(String[] args) {
        ApplicationContext apc = SpringApplication.run(SpringBootReactApplication.class, args);
        for (String s : apc.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        
    }

}
