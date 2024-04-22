package animals.interfaces;

public interface Herbivoro {
    default public void comerHierba() {
        System.out.println("Implementacion por defecto de comer hierba");
    };
}
