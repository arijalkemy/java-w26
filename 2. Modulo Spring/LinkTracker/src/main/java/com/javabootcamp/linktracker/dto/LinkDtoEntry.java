package com.javabootcamp.linktracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDtoEntry {
    String url;
    String password;
}
