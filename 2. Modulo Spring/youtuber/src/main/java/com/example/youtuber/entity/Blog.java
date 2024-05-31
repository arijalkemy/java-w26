package com.example.youtuber.entity;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Blog {
    private String title;
    private String name;
    private LocalDate date;
}
