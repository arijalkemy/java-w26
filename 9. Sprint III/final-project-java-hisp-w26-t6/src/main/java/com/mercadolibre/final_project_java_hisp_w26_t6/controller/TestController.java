package com.mercadolibre.final_project_java_hisp_w26_t6.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('SUPERVISOR')")
public class TestController {

    @GetMapping("/test")
    ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

}
