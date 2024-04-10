package org.example;

import CarreraDeLaSelva.CarreraDeLaSelva;
import Categorias.Categoria;
import Categorias.CircuitoAvanzado;
import Categorias.CircuitoChico;
import Categorias.CircuitoMediano;
import Participante.Participante;
import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {

        CarreraDeLaSelva carreraDeLaSelva = new CarreraDeLaSelva();

        Categoria circuitoAvanzado = new CircuitoAvanzado();
        Categoria circuitoChico = new CircuitoChico();
        Categoria circuitoMediano = new CircuitoMediano();

        Participante participante = new Participante(1,"Nacho", "Ruiz Diaz",
                LocalDate.of(2002,3,30),"1166944774","1166944774",
                "A+", "44080739"
        );
        Participante participante2 = new Participante(2,"Joaquin", "Diaz",
                LocalDate.of(2010,3,30),"1166944774","1166944774",
                "A+", "44080739"
        );
        Participante participante3 = new Participante(3,"Felipe", "Ruiz",
                LocalDate.of(2007,3,30),"1166944774","1166944774",
                "A+", "44080739"
        );
        Participante participante4 = new Participante(4,"Julieta", "Ruiz",
                LocalDate.of(2000,3,30),"1166944774","1166944774",
                "A+", "44080739"
        );

        carreraDeLaSelva.inscribir(participante,circuitoAvanzado);
        carreraDeLaSelva.inscribir(participante2,circuitoChico);
        carreraDeLaSelva.inscribir(participante3,circuitoMediano);
        carreraDeLaSelva.inscribir(participante4,circuitoMediano);


        carreraDeLaSelva.mostrarInscripciones();


        System.out.println();
        System.out.println();
        System.out.println();
        carreraDeLaSelva.desinscribir(participante3);

        System.out.println();
        System.out.println();
        System.out.println();
        carreraDeLaSelva.mostrarMontoRecaudadoPorCategoria();

        carreraDeLaSelva.mostrarTotalRecaudado();


    }
}
