package com.example.ejercicioTres.Animal;

import com.example.ejercicioTres.Interfaces.ICarnivorous;

public class Dog extends Animal implements ICarnivorous{

    public Dog(String name, int age){
        super(name, age);

    }

    @Override
    public void makeSound(){
        System.out.println("Woof!");
        
    }

    @Override
    public void eatMeat(){
        System.out.println("Dog goes woof! while eating meat!");
        
    }


}
