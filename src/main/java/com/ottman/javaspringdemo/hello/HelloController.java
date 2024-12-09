package com.ottman.javaspringdemo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @GetMapping("/sayhello")
    public String sayHello() {
        return "Hello, Spring Boot 4!";
    }
}