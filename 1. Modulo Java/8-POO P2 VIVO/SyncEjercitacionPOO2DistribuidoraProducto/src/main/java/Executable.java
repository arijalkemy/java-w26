public class Executable {
    public static void main(String[] args) {
        Product [] products = new Product[2];
        products[0] = new Perishable("Leche", 1500, 3);
        products[1] = new Perishable("Queso", 6500, 1);

       int numberOfProducts = 1;
       double totalPrice = 0;

        for (Product producto : products) {
            totalPrice += producto.calculate(numberOfProducts);
        }
        System.out.println("El precio total al vender 5 productos de cada tipo es: " + totalPrice);
    }


}
