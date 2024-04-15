public class Distribuidora {
    public static void main(String[] args) {
        // Crear array de productos
        Producto[] productos = new Producto[2];
        productos[0] = new Perecedero("Manzanas", 2.5, 2);
        productos[1] = new NoPerecedero("Arroz", 1.8, "Granos");

        // Imprimir precio total al vender 5 productos de cada tipo
        int cantidad = 5;
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(cantidad);
        }
        System.out.println("Precio total al vender " + cantidad + " productos de cada tipo: $" + precioTotal);
    }
}