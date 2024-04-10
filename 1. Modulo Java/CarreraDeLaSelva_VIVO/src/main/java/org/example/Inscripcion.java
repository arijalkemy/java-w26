package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    Set<Participante> participanteSet = new HashSet<>();
    int contadorNumeroInscripcion = 0;
    public int inscribirse(Participante participante, int idCategoria) {
        Categoria categoria = new Categoria(idCategoria);
        int response = categoria.validarCategoria(participante);
        if (response == -1){
            return -1;
        }else{
            contadorNumeroInscripcion++;
            participante.numeroInscripcion = contadorNumeroInscripcion;
            participante.categoria = categoria;
            participanteSet.add(participante);
            return 1;
        }
    }

    public ArrayList<String> listarParticipantes(int idCategoria) {
        ArrayList<String> participantesCategoria = new ArrayList<String>();
        for (Participante participante : participanteSet) {
            if (participante.categoria.id == idCategoria) {
                participantesCategoria.add(participante.toString());
            }
        }
        return participantesCategoria;
    }

    public int desinscribir(int noInscripcion) {
        for (Participante participante : participanteSet) {
            if (participante.numeroInscripcion == noInscripcion) {
                int categoriaParticipante = participante.categoria.id;
                participanteSet.remove(participante);
                return categoriaParticipante;
            }
        }
        return -1;
    }
}
