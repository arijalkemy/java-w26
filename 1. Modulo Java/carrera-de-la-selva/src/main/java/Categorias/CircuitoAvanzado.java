package Categorias;

import Participante.Participante;
import enums.ECategoria;

public class CircuitoAvanzado extends Categoria {
    private int edadMinima = 18;

    public CircuitoAvanzado(){
        super();
        this.id = ECategoria.ID_CIRCUITO_AVANZADO.ordinal();
        this.nombre = "Circuito Avanzado";
        this.descripcion = "10 km por selva, arroyos, barro y escalada en piedra.";
    }

    @Override
    public boolean puedeInscribirse(Participante participante) {
        return participante.getEdad() >= this.edadMinima;
    }

    @Override
    public double getMontoAAbonar(Participante participante) {
        return 2800;
    }
}
