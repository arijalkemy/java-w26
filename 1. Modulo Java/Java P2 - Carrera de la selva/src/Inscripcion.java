public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    
    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        if (participante.getEdad() >= categoria.getEdadMinima()){
            this.numero = numero;
            this.categoria = categoria;
            this.participante = participante;
        } else {
            System.out.println("No se pueden inscribir menores");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    } 
    
}
