package org.example.POO_P1_VIVO;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Person {

    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;
    @Setter
    private Double imc;
    @Setter
    private HealtCondition healtCondition = HealtCondition.UNDEFINED;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.setWeight(weight);
        this.setHeight(height);
        this.setImc(calculateImc());
        this.setHealtCondition(calcHealtCondition());
    }


    public Double calculateImc() {
        return (this.getWeight() / (Math.pow(this.getHeight(), 2)));
    }

    public boolean esMayorDeEdad() {
        return this.getAge() >= 18;
    }

    public HealtCondition calcHealtCondition() {
        if (this.getImc() < 20.0)
            return HealtCondition.UNDER_WEIGHT;

        if (this.getImc() <= 25.0)
            return HealtCondition.HEALTHY;
        else
            return HealtCondition.OVERWEIGHT;
    }

    public void setWeight(double weight) {
        if (weight == 0) throw new RuntimeException("El Peso de ".concat(this.name).concat(" no puede ser 0"));
        else this.weight = weight;
    }

    public void setHeight(double height) {
        if (height == 0) throw new RuntimeException("La Altura de ".concat(this.name).concat(" no puede ser 0"));
        else this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", imc='" + getImc() + '\'' +
                ", esMayorDeEdad='" + esMayorDeEdad() + '\'' +
                ", Estado de Salud='" + healtCondition.getValue() + '\'' +
                '}';
    }

}
