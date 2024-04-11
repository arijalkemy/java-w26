package org.example.AbstractClass_Interfaces.Ejercicio_4.Implements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.AbstractClass_Interfaces.Ejercicio_4.Comparators.CompareByMark;
import org.example.AbstractClass_Interfaces.Ejercicio_4.Comparators.CompareByPrice;


@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Vehicle implements CompareByMark<Vehicle>, CompareByPrice<Vehicle> {

    private String model;

    private String brand;

    private int cost;

    @Override
    public int compareToMark(Vehicle o) {
        return this.getBrand().compareTo(o.getBrand());
    }

    @Override
    public int compareToPrice(Vehicle o) {
        return this.getCost() - o.getCost();
    }
}
