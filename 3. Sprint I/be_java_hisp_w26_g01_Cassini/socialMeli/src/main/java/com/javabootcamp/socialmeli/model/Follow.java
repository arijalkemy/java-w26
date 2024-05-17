package com.javabootcamp.socialmeli.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    private User follower;
    private User followed;
    private LocalDate followUpDate;
}
