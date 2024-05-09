package org.example.g14.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.g14.dto.ProductDto;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
}
