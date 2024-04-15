package org.example;

import java.util.List;

public class RespositoryCliente {
    List<Cliente> clientes;

    private RepositoryLocalizador repositoryLocalizador;

    public void reservasAnteriores(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.equals(cliente)) {
                for (Localizador l : repositoryLocalizador.getLocalizadorList()) {
                    for (Reserva r : l.getReservas()) {
                        if (r.getCliente().equals(cliente)) {
                            System.out.println("Reserva: " + r);
                        }
                    }
                }
            }
        }
    }

    public void aplicarDescuentos(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.equals(cliente)) {
                System.out.println("Descuentos aplicados: " + c.getDescuentos());
            }
        }
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

}
