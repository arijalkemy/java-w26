package org.example.model;

import org.example.repository.RepositorioCliente;
import org.example.repository.RepositorioLocalizador;

public class Agencia {
    private RepositorioCliente repositorioCliente;
    private RepositorioLocalizador repositorioLocalizador;

    public Agencia () {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioLocalizador = new RepositorioLocalizador();
    }
    public void registrarCliente(Cliente c) {
        this.repositorioCliente.add(c);
    }
    public void registrarLocalizador(Localizador l) {
        int idCliente = l.getCliente().getId();
        if (repositorioLocalizador.findByIdCliente(idCliente).size() > 2) {
            l.aplicarDescuento(5);
        }
        this.repositorioLocalizador.add(l);
    }

}
