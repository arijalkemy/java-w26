package com.company;

import java.util.HashSet;
import java.util.Set;
import com.company.CarreraDeLaSelva;

public class Main {

    public static void main(String[] args) {
        HashSet<Categoria> categorias = new HashSet<Categoria>();
        HashSet<Participante> participantes = new HashSet<Participante>();

        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos.", 1500, 1300);
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro.", 2300, 2000);
        Categoria circuitoAvanzado = new Categoria(3, "CircuitoAvanzado", "10 km por selva, arroyos, barro y escalada en piedra.", 2800, -1);

        categorias.add(circuitoChico);
        categorias.add(circuitoMedio);
        categorias.add(circuitoAvanzado);

        Participante primerParticipante = new Participante(1, "42951261", "Tomás", "Donzis", 23, "1166876181", "1151744971", "0+");
        circuitoChico.inscribir(1, primerParticipante);
        Participante segundoParticipante = new Participante(2, "12345678", "Toto", "D", 15, "11", "11", "A");
        Participante tercerParticipante = new Participante(3, "12345671", "Toto", "D", 40, "11", "11", "A");
        circuitoMedio.inscribir(2, segundoParticipante);
        circuitoAvanzado.inscribir(3, tercerParticipante);

        participantes.add(primerParticipante);
        participantes.add(segundoParticipante);
        participantes.add(tercerParticipante);

        CarreraDeLaSelva carreraDeLaSelva = new CarreraDeLaSelva(categorias, participantes);

        System.out.println(circuitoMedio.montoTotal());
        System.out.println(carreraDeLaSelva.montoTotal());
    }
}
