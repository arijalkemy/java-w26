package EjercicioSupermercado;

public class EjSupermercadoMain {

    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado();
        Cliente primerCliente = new Cliente("38123123","Jose", "Carlos");
        supermercado.agregarClientes( primerCliente,new Cliente("21123453","Maria", "Rodriguez"), new Cliente("18393272","Raul", "Gomez"));

        supermercado.mostrarClientes();

        System.out.println("---------------------------");

        supermercado.eliminarCliente(primerCliente);
        supermercado.mostrarClientes();

        System.out.println("---------------------------");
        supermercado.eliminarCliente("123");
        System.out.println("---------------------------");

        supermercado.eliminarCliente("18393272");
        supermercado.mostrarClientes();


        Factura factura = new Factura( new Cliente("38123123","Jose", "Carlos") );

        factura.agregarItem( new Item("Helado", 25.00) );
        factura.agregarItem( new Item("Pan", 17.00) );
        factura.agregarItem( new Item("Trapo", 32.00) );
        factura.agregarItem( new Item("Jabon", 12.00) );

        System.out.println("---------------------------");

        supermercado.agregarFacturas(factura);
        supermercado.mostrarFacturas();

        System.out.println("---------------------------");
        supermercado.mostrarClientes();
    }

}
