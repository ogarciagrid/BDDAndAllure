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
public class BDDTest {

    public static void main(String[] args) throws Exception{
        try{
            SpringApplication.run(BDDTest.class);
            System.exit(0);
        }catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }

    }

    @Bean
    public ObjectMapper objectMapper() {return new ObjectMapper();}
}
