package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SintomaRepository {

    public static final List<Sintoma> listSintomas = new ArrayList<>();

    static{
        llenarSintomas();
    }

    private static void llenarSintomas(){
        Sintoma fiebre = new Sintoma("123","Fiebre","Medio");
        Sintoma tos = new Sintoma("124","Tos","Medio");
        Sintoma sangrado = new Sintoma("125","Sangrado","Alto");

        listSintomas.add(fiebre);
        listSintomas.add(tos);
        listSintomas.add(sangrado);

    }

}
