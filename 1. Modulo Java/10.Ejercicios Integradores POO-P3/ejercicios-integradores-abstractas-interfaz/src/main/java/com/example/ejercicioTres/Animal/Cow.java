package com.example.ejercicioTres.Animal;

import com.example.ejercicioTres.Interfaces.IHerbivorous;

public class Cow extends Animal implements IHerbivorous{

    public Cow(String name, int age){
        super(name, age);

    }

    @Override
    public void makeSound(){
        System.out.println("Moooo!");
        
    }

    @Override
    public void eatHerb(){
        System.out.println("Cow goes Moooo! while eating herb!");
    }

}
