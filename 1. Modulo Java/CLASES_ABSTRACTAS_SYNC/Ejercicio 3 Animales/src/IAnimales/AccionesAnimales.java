package IAnimales;

import Animales.Animal;
import Animales.Gato;
import Animales.Perro;
import Animales.Vaca;

public interface AccionesAnimales
{
    public static void hacerComer(Animal animal)
    {
        String tipo_animal = "";

        if (animal.getClass() == Gato.class) {
            tipo_animal = "El Gato";
        }

        if (animal.getClass() == Perro.class) {
            tipo_animal = "El Perro";
        }

        if (animal.getClass() == Vaca.class) {
            tipo_animal = "La Vaca";
        }

        System.out.println(tipo_animal + " esta: ");
        animal.comer();
        
    }
}