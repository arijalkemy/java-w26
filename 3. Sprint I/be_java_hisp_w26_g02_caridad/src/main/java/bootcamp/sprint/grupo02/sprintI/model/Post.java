package bootcamp.sprint.grupo02.sprintI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private int sellerId;
    private LocalDate date;
    private int category;
    private double price;
    private Product product;
    private double discount;
    private boolean hasPromo;
}
