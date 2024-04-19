package com.example._11_linktracer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/URL")
public class UrlController {

    @GetMapping("/ping")
    public String pingpong(){
        return "pong";
    }


}
