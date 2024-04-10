public class Inscripcion {
    
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calculateMonto();
    } 

    
    public int getNumero() {
        return this.numero;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Participante getParticipante() {
        return this.participante;
    }
    
    public double getMonto() {
        return this.monto;
    }


    private double calculateMonto() {
        return (this.participante.isMayor()) ? this.categoria.getMayorPricing() : this.categoria.getMinorPricing();
    }
}
