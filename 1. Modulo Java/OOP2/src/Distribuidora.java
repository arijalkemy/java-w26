public class Distribuidora {
    private Producto[] productos = new Producto[10];

    public Distribuidora() {
        for(int i = 0; i < 5; i++){
            productos[i] = new Perecedero("Producto" + i, i, 5 - i);
            productos[5 + i] = new NoPerecedero("Producto" + (5 + i), 5 + i, "Blobo");
        }
    }

    public double precioTotal(){
        double cur_price = 0;
        for(Producto producto : productos){
            cur_price += producto.calcular(5);
        }
        return cur_price;
    }
}
