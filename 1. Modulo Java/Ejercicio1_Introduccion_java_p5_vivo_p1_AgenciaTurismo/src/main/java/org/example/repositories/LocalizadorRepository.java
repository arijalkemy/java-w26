package org.example.repositories;

import org.example.Localizador;

import java.util.List;

public class LocalizadorRepository extends Repository<Localizador> {
    @Override
    public Localizador agregar(Localizador dato) {
        baseDeDatos.agregarLocalizador(dato);
        return dato;
    }

    @Override
    public List<Localizador> getObjetos() {
        return baseDeDatos.getLocalizadores();
    }

    @Override
    public void actualizar(Localizador dato) {

    }
}
