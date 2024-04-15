package punto3;
public class Gato extends Animal implements Carnivoro{

    public void comerCarne() {
        System.out.println("El gato está comiendo carne");
    }
    public void sonido(){
        System.out.println("Miau miau");
    }
}