package com.kakao.demo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="info")
@Setter
@Getter
class Info {
    private String name;
    private int age;
    private List<String> locations;
}