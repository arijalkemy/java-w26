package org.example.Repository;

import com.sun.source.tree.BreakTree;
import org.example.Cliente;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository <Cliente> {

    List<Cliente> clienteList = new ArrayList<Cliente>();

    @Override
    public void alta(Cliente objeto) {
        clienteList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente cliente : clienteList) {
            System.out.println(cliente.imprimir());
        }
    }

    @Override
    public Optional<Cliente> buscar(Integer id) {

        for (Cliente item : clienteList)
            if(id.equals(item.getDni())) {
                System.out.println("Encontre el cliente " + item.imprimir());
                return Optional.of(item);
            }
        return Optional.empty() ;
    }

    @Override
    public void baja(Long id) {
        clienteList.remove(id);
    }

}
