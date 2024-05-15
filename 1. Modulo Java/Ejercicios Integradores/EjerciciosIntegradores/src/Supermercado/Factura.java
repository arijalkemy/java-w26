package Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private List<Producto> conteoProductos;

    public Factura() {
        conteoProductos = new ArrayList<>();
    }

    public void agregarProductos(Producto nuevoProducto){
        conteoProductos.add(nuevoProducto);
        System.out.println("BIP");
    }

    public void cambiarCantidad(String codigoProducto, Integer nuevaCantidad) {

        Producto aEditar = conteoProductos.stream().filter(p -> p.getCodigo().equals(codigoProducto)).findFirst().get();
        aEditar.setCantidad(nuevaCantidad);
        System.out.println("Actualizada la cantida de productos a:"+nuevaCantidad);
    }

    public double calcularTotal(){
        double total = 0;
        for (Producto subtotal: conteoProductos) {
            total +=subtotal.calcularSubtotal();
        }
        return total;
    }

    public void retirarProducto(String codigoProducto){
        for (Producto p: conteoProductos
             ) {
            if(p.getCodigo().equals(codigoProducto)){
                conteoProductos.remove(p);
                System.out.println(p.getNombre()+ " Eliminado de la lista");
                break;
            }
            else {
                System.out.println("Producto no encontrado");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder productos = new StringBuilder();
        conteoProductos.forEach(p -> {productos.append(p.toString());});
        return "Factura{\n" +
                "conteoProductos=" + productos +
                '}';
    }
}
