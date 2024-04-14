public class Main {
    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();


        Producto productoNoPerecedero1 = new NoPerecedero("fideos", 900, "grano");
        Producto productoNoPerecedero2 = new NoPerecedero("arroz", 600, "grano");
        Producto productoNoPerecedero3 = new NoPerecedero("lentejas", 700, "enlatado");
        Producto productoNoPerecedero4 = new NoPerecedero("garbanzos", 750, "enlatado");
        Producto productoNoPerecedero5 = new NoPerecedero("aceite", 3000, "liquido");

        Producto perecedero1 = new Perecedero("leche", 900, 1);
        Producto perecedero2 = new Perecedero("fruta", 100, 2);
        Producto perecedero3 = new Perecedero("carne", 3000, 3);
        Producto perecedero4 = new Perecedero("pescado", 1200, 4);
        Producto perecedero5 = new Perecedero("pan", 1500, 5);


        distribuidora.agregarProducto(productoNoPerecedero1, productoNoPerecedero2, productoNoPerecedero3,
                productoNoPerecedero4, productoNoPerecedero5, perecedero1,
                perecedero2, perecedero3, perecedero4);


        distribuidora.getProductos().forEach(System.out::println);

        System.out.println("Precio total: ");

        System.out.println(distribuidora.calcularPrecioTotal(5));
    }
}
