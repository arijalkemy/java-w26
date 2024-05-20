package com.example.miniseries2;

import com.example.miniseries2.enums.GeneroEnum;
import com.example.miniseries2.model.MiniSerie;
import com.example.miniseries2.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniSeries2Application {


    public static void main(String[] args) {
        SpringApplication.run(
                MiniSeries2Application.class,
                args
        );
    }

}
