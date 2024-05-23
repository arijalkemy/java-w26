package org.example.miniseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class MiniSeriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniSeriesApplication.class, args);
    }

}
