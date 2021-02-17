package com.kakao.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class DemoApplication {

    private final Info info;

    @GetMapping("/")
    public String greeting() {
        return "Hi, there.";
    }

    @GetMapping("/info")
    public Info info() {
        return info;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Service
    class Runner implements CommandLineRunner {
        @Override
        public void run(String... args) {
            String env = System.getenv("phase");
            System.out.println("=== phase : [" + env + "] ===");
        }
    }

}
