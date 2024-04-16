package org.example;

import org.example.model.Cliente;
import org.example.repository.ClienteImpl;

public class App 
{
    public static void main( String[] args )
    {
        ClienteImpl clienteImpl = new ClienteImpl();
        Cliente cliente1 = new Cliente(123456L, "Cliente1", "Apellido1");
        Cliente cliente2 = new Cliente(1234567L, "Cliente2", "Apellido2");
        Cliente cliente3 = new Cliente(12345678L, "Cliente3", "Apellido3");

        clienteImpl.save(cliente1);
        clienteImpl.save(cliente2);
        clienteImpl.save(cliente3);

        clienteImpl.mostrarPantalla();

        clienteImpl.buscar(123456L);

        clienteImpl.elminar(123456L);
    }
}
