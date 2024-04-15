package org.example;

import org.example.entidades.Cliente;
import org.example.entidades.Localizador;
import org.example.repositorios.impl.IRepositorioImplCliente;
import org.example.repositorios.impl.IRepositorioImplLocalizador;

import java.util.ArrayList;
import java.util.List;

public class AgenciaDeTurismo {
    private IRepositorioImplCliente repoClientes;
    private IRepositorioImplLocalizador repoLocalizadores;

    public AgenciaDeTurismo(IRepositorioImplCliente repoClientes, IRepositorioImplLocalizador repoLocalizadores) {
        this.repoClientes = repoClientes;
        this.repoLocalizadores = repoLocalizadores;
    }

    public void realizarPago(Localizador localizador, Cliente cliente){

    }
}
