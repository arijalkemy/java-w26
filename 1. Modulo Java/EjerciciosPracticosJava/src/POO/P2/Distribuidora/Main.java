package POO.P2.Distribuidora;

public class Main {
    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();

        distribuidora.agregarProducto(new Producto("Producto", 10));
        distribuidora.agregarProducto(new Pedecedero("Pedecedero", 10, 3));
        distribuidora.agregarProducto(new NoPedecedero("No pedecedero", 10, "Fideos"));

        distribuidora.venderProductos();
    }
}