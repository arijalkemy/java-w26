public class Main {
    public static void main(String[] args) {
        Perro perrito = new Perro();
        Gato gatito = new Gato();
        Vaca vaca = new Vaca();

        perrito.hacerSonido();
        perrito.comerCarne();
        perrito.comerAnimal(vaca);
        System.out.println("-----------");
        gatito.hacerSonido();
        gatito.comerCarne();
        gatito.comerAnimal(gatito);
        System.out.println("-----------");
        vaca.hacerSonido();
        vaca.comerHierba();
        vaca.comerAnimal(vaca);

    }
}