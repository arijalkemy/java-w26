package org.responseentity.jpa_demo.service;

import org.responseentity.jpa_demo.model.Animal;
import org.responseentity.jpa_demo.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    IAnimalRepository animalRepository;

    public void SaveAnimal(){
        Animal animal = new Animal();
    }
}
