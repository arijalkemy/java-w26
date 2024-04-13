public class Main {
    public static void main(String[] args) {
        Perro perrito = new Perro();
        perrito.emitirSonidos();
        perrito.comerCarne();

        System.out.println("-------");

        Gato gatito = new Gato();
        gatito.comerHierba();
        gatito.emitirSonidos();
    }
}