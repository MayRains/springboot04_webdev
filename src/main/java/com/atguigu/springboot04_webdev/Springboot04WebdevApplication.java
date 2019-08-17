package com.atguigu.springboot04_webdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class Springboot04WebdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04WebdevApplication.class, args);
    }

}
