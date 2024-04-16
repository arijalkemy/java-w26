package org.example.Ejercicio3;

//en el Main la creación de diferentes animales y la invocación de sus respectivas implementaciones de métodos.
//Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto
// de cualquier tipo de animal como parámetro, invoque al método para comer según corresponda a dicho animal.
public class Main {

    //metodo para comer animales
    public static void comerAnimal(Animal animal){
        animal.comer();
    }


        public static void main(String[] args) {
            Animal perrito = new Perro();
            Animal gatito = new Gato();
            Animal vaquita = new Vaca();
            Animal pescado = new Pez();

            //emitiendo sus sonidos
            perrito.emitirSonido();
            gatito.emitirSonido();
            vaquita.emitirSonido();

            //animales comiendo otros animales
            System.out.println("Animales comiendo :");
            comerAnimal(vaquita);
            comerAnimal(pescado);

        }
    }



