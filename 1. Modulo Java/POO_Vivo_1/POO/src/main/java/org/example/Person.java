package org.example;

public class Person {
    String name;
    int age;
    String dni;
    double weigth;
    double heigth;

    public Person() {

    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weigth, double heigth) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weigth = weigth;
        this.heigth = heigth;
    }

    public int IMCCalculate() {
        double IMC = this.weigth / (Math.pow(this.heigth, 2));

        if (IMC < 20) {
            return -1;
        } else if (IMC >= 20 && IMC <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public String imcState(int imc) {
        switch (imc) {
            case -1:
                return "Peso bajo";
            case 0:
                return "Peso Ideal";
            case 1:
                return "Peso alto";
            default:
                return null;
        }
    }

    public boolean isLegalAge() {
        if (this.age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weigth=" + weigth +
                ", heigth=" + heigth +
                ", legalAge=" + isLegalAge() +
                ", IMC=" + imcState(IMCCalculate()) +
                '}';
    }
}

