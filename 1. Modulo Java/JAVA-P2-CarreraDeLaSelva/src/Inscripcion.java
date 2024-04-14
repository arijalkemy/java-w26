public class Inscripcion {
    private static int contadorId;
    private int id;

    private double monto;
    private Categoria categoria;
    private Participante participante;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.id = this.contadorId;
        this.categoria = categoria;
        this.participante = participante;
        contadorId++;
        this.calcularCosto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getMonto(){
        return this.monto;
    }

    private void calcularCosto(){
        double costoInscripcion = 0;
        if(this.participante.getEdad()<18){
            costoInscripcion = this.categoria.getPrecioMenor();

        }else {
            costoInscripcion = this.categoria.getPrecioMayor();
        }
        this.monto = costoInscripcion;
    }

}
