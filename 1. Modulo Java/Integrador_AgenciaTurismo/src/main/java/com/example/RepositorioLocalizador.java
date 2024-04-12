package com.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements Repositorio<Localizador> {
    private List<Localizador> localizadores;

    public RepositorioLocalizador() {
        // Crear algunos clientes
        Cliente cliente1 = new Cliente(1, "Juan", "Perez");
        Cliente cliente2 = new Cliente(2, "Maria", "Gomez");

        // Crear algunas reservas para el primer cliente
        List<Reserva> reservas1Cliente1 = new ArrayList<>();
        reservas1Cliente1.add(new Reserva(101, "Vuelo a Brasil", new Producto(125D,"Vuelo"), 10.5, 2));
        reservas1Cliente1.add(new Reserva(102, "Vuelo a Brasil", new Producto(10D,"Vuelo"), 15.75, 1));
        reservas1Cliente1.add(new Reserva(101, "Reserva de hotel 5 estrellas", new Producto(125D,"Reserva Hotel"), 10.5, 2));
        reservas1Cliente1.add(new Reserva(102, "Reserva de hotel 3 estrellas", new Producto(10D,"Reserva Hotel"), 15.75, 1));

        // Crear algunas reservas para el segundo cliente
        List<Reserva> reservas2Cliente1 = new ArrayList<>();
        reservas2Cliente1.add(new Reserva(201, "Hotel 5 personas", new Producto(1599D,"Hotel cerca de la playa"), 20.0, 3));
        reservas2Cliente1.add(new Reserva(202, "Visita museo guiada", new Producto(125D,"Museo de artes visuales"), 8.0, 5));

        // Crear los objetos Localizador
        Localizador localizador1 = new Localizador(cliente1, reservas1Cliente1);
        Localizador localizador2 = new Localizador(cliente1, reservas2Cliente1);

        localizadores.add(localizador1);
        localizadores.add(localizador2);
    }

    @Override
    public List<Localizador> findAll() {
        return this.localizadores;
    }

    @Override
    public void add(Localizador obj) {
        if (!localizadores.contains(obj))
            localizadores.add(obj);
    }

    @Override
    public Localizador find(int id) {
        return localizadores.get(id);
    }
}
