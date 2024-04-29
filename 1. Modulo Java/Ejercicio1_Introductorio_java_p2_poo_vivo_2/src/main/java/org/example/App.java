package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<Producto> productos = Arrays.asList(
                new Perecedero("Galletas", 1300, 2),
                new Perecedero("Gasesosa", 3000, 2),
                new Perecedero("Cafe", 20000, 2),
                new Perecedero("Chocolate", 8000, 2),
                new Perecedero("Arroz", 9800, 2),
                new NoPerecedero("Jabon", 3000, "limpieza"),
                new NoPerecedero("Papel", 1200, "limpieza"),
                new NoPerecedero("Playera", 30000, "ropa"),
                new NoPerecedero("Camisa", 25000, "ropa"),
                new NoPerecedero("Teclado", 150000, "electronico")
        );
        double total = productos.stream().map(p -> p.getPrecio()).reduce(0.0, Double::sum);
        System.out.println(total);
    }
}
