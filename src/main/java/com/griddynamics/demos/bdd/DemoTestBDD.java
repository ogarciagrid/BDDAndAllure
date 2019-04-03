package com.griddynamics.demos.bdd;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.griddynamics.qa.sprimber.autoconfigure.annotation.EnableSprimber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableSprimber
@EnableAsync
public class DemoTestBDD {

    public static void main(String[] args) throws Exception{
        SpringApplication.exit(SpringApplication.run(DemoTestBDD.class));
    }

    @Bean
    public ObjectMapper objectMapper() {return new ObjectMapper();}
}
