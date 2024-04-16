package com.EjercicioDeportista.EjercicioDeportista.utils;

import com.EjercicioDeportista.EjercicioDeportista.clases.Deporte;
import com.EjercicioDeportista.EjercicioDeportista.clases.Persona;
import com.EjercicioDeportista.EjercicioDeportista.clases.dto.DeportistaDTO;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    public static List<Deporte> obtenerDeportes()
    {
        List<Deporte> listDeportes = new ArrayList<>();
        listDeportes.add(new Deporte("Futbol",2));
        listDeportes.add(new Deporte("Voley",3));
        listDeportes.add(new Deporte("Boxeo",7));
        listDeportes.add(new Deporte("Basquet",7));
        return  listDeportes;
    }


    public static List<DeportistaDTO> obtenerDeportistas()
    {
        List<DeportistaDTO> listDeportistas = new ArrayList<>();
        listDeportistas.add(new DeportistaDTO("Matias","Gomez","Futbol"));
        listDeportistas.add(new DeportistaDTO("Gonzalo","Palomo","Voley"));
        listDeportistas.add(new DeportistaDTO("Franco","Nicolas","Boxeo"));
        listDeportistas.add(new DeportistaDTO("Juan","Pepe","Basquet"));
        return  listDeportistas;
    }
}
