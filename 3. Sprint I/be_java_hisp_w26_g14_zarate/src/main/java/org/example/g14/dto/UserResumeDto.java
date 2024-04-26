package org.example.g14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResumeDto {
    private int user_id;
    private String user_name;
    private int products_quantity;
    private int products_with_promo;
    private LocalDate date_first_product;
    private LocalDate date_last_product;
    private double max_price;
    private double min_price;
    private double average_price;
    private double total_published;
    private double total_published_with_discount;
}
