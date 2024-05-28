package com.mercadolibre.qatesters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping(path = "api")
public class QaTestersApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaTestersApplication.class, args);
    }

}
