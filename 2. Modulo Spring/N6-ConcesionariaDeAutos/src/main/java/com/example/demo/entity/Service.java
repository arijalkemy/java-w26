package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long kilometers;
    private String descriptions;

}
