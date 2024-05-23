package org.example.showroom.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestClothesDTO implements Serializable {
    private String name;
    private String type;
    private String color;
    private float size;
    private String brand;
    private float price;
    private int stock;

}
