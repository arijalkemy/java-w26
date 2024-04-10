package Categorias;

import Participante.Participante;
import enums.ECategoria;

public class CircuitoChico extends Categoria {

    public CircuitoChico(){
        super();
        this.id = ECategoria.ID_CIRCUITO_CHICO.ordinal();
        this.nombre = "Circuito Chico";
        this.descripcion = "2 km por selva y arroyos.";
    }


    @Override
    public boolean puedeInscribirse(Participante participante) {
        return true;
    }

    @Override
    public double getMontoAAbonar(Participante participante) {
        return participante.getEdad() < 18 ? 1300 : 1500;
    }
}
