import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> listaProductos = new ArrayList<>();
    private double totalCompra = 0;

    public void crearFactura(){
        Scanner teclado = new Scanner(System.in);
        boolean escape = false;
        cliente = new Cliente();

        System.out.println("----- Ingrese los datos del cliente ----- ");
        System.out.println("Nombre y Apellido: ");
        String nombreApellido = teclado.next();
        teclado.nextLine();
        cliente.setNombreApellido(nombreApellido);
        System.out.println("Documento: ");
        int documento = teclado.nextInt();
        cliente.setDni(documento);

        while (!escape){
            //genera una instancia de Productos por cada llamada
            cargaProductos();
            System.out.println("---------------------------------------");
            System.out.println("Desea agregar otro producto? (´No´ para salir, cualquier tecla para continuar.");
            String salida = teclado.next();
            if (salida.equals("No")){
                escape = true;
            }
        }
        teclado.close();
    }

    private void cargaProductos(){
        Scanner tecladoProd = new Scanner(System.in);
        System.out.println("----- Ingrese los productos a comprar ----- ");
        System.out.println("Ingrese el codigo del producto: ");
        int codigo = tecladoProd.nextInt();
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = tecladoProd.next();
        System.out.println("Ingrese la cantidad a llevar: ");
        int cantidad = tecladoProd.nextInt();
        System.out.println("Ingrese el precio unitario del producto: ");
        double precioUnitario = tecladoProd.nextDouble();
        Producto producto = new Producto(codigo, nombre, cantidad, precioUnitario);
        listaProductos.add(producto);
        totalCompra += producto.getTotalProducto();
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
