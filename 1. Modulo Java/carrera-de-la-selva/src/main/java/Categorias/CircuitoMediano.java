package Categorias;

import Participante.Participante;
import enums.ECategoria;

public class CircuitoMediano extends Categoria {

    public CircuitoMediano(){
        super();
        this.id = ECategoria.ID_CIRCUITO_MEDIANO.ordinal();
        this.nombre = "Circuito Mediano";
        this.descripcion = "5 km por selva, arroyos y barro.";
    }

    @Override
    public boolean puedeInscribirse(Participante participante) {
        return true;
    }

    @Override
    public double getMontoAAbonar(Participante participante) {
        return participante.getEdad() < 18 ? 2000 : 2300;
    }
}
