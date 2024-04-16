package animals.interfaces;

public interface Carnivoro {
    default public void comerCarne() {
        System.out.println("Implementacion por defecto de comer carne");
    }
}
