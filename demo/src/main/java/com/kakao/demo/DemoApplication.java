package com.kakao.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class DemoApplication {

    @GetMapping("/knock")
    public String greeting() {
        return "Hi, there.";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}