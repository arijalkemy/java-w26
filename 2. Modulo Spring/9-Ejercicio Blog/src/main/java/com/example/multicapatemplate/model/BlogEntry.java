package com.example.multicapatemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BlogEntry {
    private int id;
    private String title;
    private String authorName;
    private LocalDate date;
}
