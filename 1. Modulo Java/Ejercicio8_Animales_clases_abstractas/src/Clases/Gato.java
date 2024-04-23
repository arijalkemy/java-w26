package Clases;

import Interfaces.Carnivoro;
//clase que hereda el comportamiento de un animal
//implementa la firma del metodo comer en su caso al ser carnivoro es comer carne
public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comerCarne() {
       return "Que rico, miau";
    }


}
