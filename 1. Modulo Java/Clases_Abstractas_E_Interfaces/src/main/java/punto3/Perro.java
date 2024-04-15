package punto3;

public class Perro extends Animal implements Carnivoro{
    public void comerCarne() {
        System.out.println("El perro está comiendo carne");
    }
    public void sonido(){
        System.out.println("Guau guau");
    }
}
