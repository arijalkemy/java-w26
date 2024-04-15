package com.example.spring_p1_vivo_mvc_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping
    public String sayHello() {
        return "Hello world!";
    }
//    @GetMapping("/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello world: " + name;
//    }
}
