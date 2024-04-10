package org.example.CarreraDeLaSelva;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public  class Category {

    private Integer id;

    private String name;

    private String description;

    private int kms;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", kms=" + kms +
                '}';
    }
}
