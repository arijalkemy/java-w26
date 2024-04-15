
public class Distribuidora {
    public static void main(String[] args) {

        Producto[] productos = new Producto[3];

        Perecedero leche = new Perecedero("Leche",900.0,2);
        NoPerecedero azucar = new NoPerecedero("Azucar",1100.0,"Endulzante");
        Perecedero yogur = new Perecedero("Yogur",800.0,3);

        productos[0] = leche;
        productos[1] = azucar;
        productos[2] = yogur;

        double precioTotal = 0;


        for (Producto p : productos){
            precioTotal+= p.calcular(5);
        }

        System.out.println("Precio total: "+precioTotal);
    }
}