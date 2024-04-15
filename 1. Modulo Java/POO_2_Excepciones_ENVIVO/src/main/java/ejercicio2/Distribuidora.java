package ejercicio2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];
        productos [0] = new Perecedero("Manzana", 20000,3);
        productos [1] = new Perecedero("Leche", 20343430,1);
        productos [2] = new NoPerecedero("Arroz", 20002210,"Grano");
        productos [3] = new NoPerecedero("Lata de atún", 2121212, "Atún");
        double precioTotal = 0;
        int cantidad = 5;
        for(Producto producto: productos){
            double precioCalculado = producto.calcularPrecio(cantidad);
            System.out.println(producto + " - Precio total por "+cantidad+" unidades: $"+precioCalculado);
            precioTotal += precioCalculado;
        }
        System.out.println("Precio total de venta de todos los productos: $" + precioTotal);
    }

}
