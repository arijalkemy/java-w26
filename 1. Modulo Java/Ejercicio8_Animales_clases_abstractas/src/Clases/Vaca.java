package Clases;

import Interfaces.Herviboro;
//clase que hereda el comportamiento de un animal
//implementa la firma del metodo comer en su caso al ser herviboro es comer hierba
public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public String comerHierba() {
        return "Muu delicioso";
    }

}
