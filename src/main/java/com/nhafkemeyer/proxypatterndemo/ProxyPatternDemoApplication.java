package com.nhafkemeyer.proxypatterndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class ProxyPatternDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyPatternDemoApplication.class, args);
    }

}
