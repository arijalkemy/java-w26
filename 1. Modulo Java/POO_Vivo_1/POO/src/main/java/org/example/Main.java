package org.example;

public class Main
{
    public static void main(String[] args){
        Person Alejandra = new Person();
        Person Nicolas = new Person("Nicolas", 28, "12345678");
        Person Mario = new Person ("Mario", 28, "1234567", 71, 1.76);

        // Example with less params than constructor
        // Person Johan = new Person("Johan", 28);
        // error

        System.out.println(Mario);
    }
}
