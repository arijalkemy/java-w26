public class Inscripcion {

    public void inscribir(Categoria categoria, Participante participante){
        if(participante.puedeInscribir(categoria)){
            participante.inscribir(categoria);
        }
    }

    public boolean estaInscripto(Participante participante){
        return participante.estaInscripto();
    }

    public void desinscribir(Participante participante){
        participante.desinscribir();
    }

    public String categoriaInscripto(Participante participante){
        return participante.getCategoria();
    }

    public double precioInscripcion(Participante participante){
        return participante.precioInscripcion();
    }
}