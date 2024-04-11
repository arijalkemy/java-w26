package org.example;

public interface IComer<T extends Animal> {
    static <T extends Animal> void comerAnimal(T animal) {
        animal.comer();
    }
}
