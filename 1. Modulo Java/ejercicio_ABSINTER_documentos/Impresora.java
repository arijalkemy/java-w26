public class Impresora {
    public static void imprimirDocumento(Imprimible documento) {
        documento.imprimir();
        System.out.println("----------------------------------");
    }
}
