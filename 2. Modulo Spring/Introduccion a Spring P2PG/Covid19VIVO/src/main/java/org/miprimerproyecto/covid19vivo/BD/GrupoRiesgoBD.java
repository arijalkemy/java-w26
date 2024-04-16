package org.miprimerproyecto.covid19vivo.BD;

import org.miprimerproyecto.covid19vivo.DTO.GrupoRiesgo;
import org.miprimerproyecto.covid19vivo.clases.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class GrupoRiesgoBD {
    public static List<Sintoma> sintoma1= new ArrayList<>();
    public static List<Sintoma> sintoma2= new ArrayList<>();
    public static List<Sintoma> sintoma3= new ArrayList<>();
    static{
        sintoma1.add(new Sintoma(120, "Fiebre", 4));
        sintoma1.add(new Sintoma(121, "Tos", 2));
        sintoma2.add(new Sintoma(122, "Respiracion", 6));
        sintoma3.add(new Sintoma(120, "Fiebre", 4));
        sintoma3.add(new Sintoma(121, "Tos", 2));
        sintoma3.add(new Sintoma(122, "Respiracion", 6));
        sintoma3.add(new Sintoma(123, "Fatiga", 3));
        sintoma3.add(new Sintoma(124, "DolorCabeza", 4));
    }


    public static List<GrupoRiesgo> listaGrupoRiesgo = new ArrayList<GrupoRiesgo>();
    static {
        listaGrupoRiesgo.add(new GrupoRiesgo(0, "Alfio", "Molina", 64, sintoma1));
        listaGrupoRiesgo.add(new GrupoRiesgo(1, "Magali", "Rodriguez", 64, sintoma2));
        listaGrupoRiesgo.add(new GrupoRiesgo(2, "Galileo", "Lorenzo", 60, sintoma3));
        listaGrupoRiesgo.add(new GrupoRiesgo(3, "Rocio", "Fernandez", 32, sintoma1));
    }

    public static List<GrupoRiesgo> findRiskPerson() {
        List<GrupoRiesgo> aux = new ArrayList<>();
        for (GrupoRiesgo grupoRiesgo : listaGrupoRiesgo) {
            if(grupoRiesgo.getEdad()>=60){
                aux.add(grupoRiesgo);
            }
        }
        return aux;
    }

}
