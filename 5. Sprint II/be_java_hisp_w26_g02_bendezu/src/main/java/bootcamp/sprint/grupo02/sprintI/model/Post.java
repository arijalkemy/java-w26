package bootcamp.sprint.grupo02.sprintI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    
    private int id;
    private int sellerId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private int category;
    private double price;
    private Product product;
    private double discount;
    private boolean hasPromo;
}
