public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante, int monto) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + numero +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
