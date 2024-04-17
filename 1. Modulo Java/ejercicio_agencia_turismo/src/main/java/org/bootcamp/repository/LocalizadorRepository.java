package org.bootcamp.repository;

import org.bootcamp.domain.Cliente;
import org.bootcamp.domain.Localizador;

import java.util.*;

public class LocalizadorRepository implements IGeneric<Localizador> {

    private static Map<Integer, Localizador> localizadores;

    public LocalizadorRepository() {
        this.localizadores = new TreeMap<>();
    }

    @Override
    public Localizador guardar(Localizador objeto) {
        localizadores.put(objeto.getId(), objeto);
        System.out.println(objeto.toString());
        System.out.println("¡Localizador guardado con exito!");
        return objeto;
    }

    @Override
    public Localizador buscar(int id) {
        return localizadores.get(id);
    }

    private void calcularDescuento(){

    }
}
