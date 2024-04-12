package com.example.ejercicioTres.Animal;

import com.example.ejercicioTres.Interfaces.ICarnivorous;

public class Cat extends Animal implements ICarnivorous{

    public Cat(String name, int age){
        super(name, age);

    }

    @Override
    public void makeSound(){
        System.out.println("Meow!");
    }

    @Override
    public void eatMeat(){
        System.out.println("Cat goes meow! while eats meat");

    }

}
