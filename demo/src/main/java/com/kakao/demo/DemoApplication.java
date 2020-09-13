package com.kakao.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @GetMapping("/")
    public String greeting() {
        return "Hi, there.";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Service
    class Runner implements CommandLineRunner {
        @Override
        public void run(String... args) {
            String env = System.getenv("hello.env");
            System.out.println("=== hello.env : [" + env + "] ===");
        }
    }

}
