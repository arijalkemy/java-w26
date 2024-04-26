public class Inscripcion {

    private int numeroInscripción;
    private Categoria categoria;
    private Participante participante;
    private double montoAbonar;

    public Inscripcion(int numeroInscripción, Categoria categoria, Participante participante) {
        this.numeroInscripción = numeroInscripción;
        this.categoria = categoria;
        this.participante = participante;
        calcularMontoAbonar();
    }

    public int getNumeroInscripción() {
        return numeroInscripción;
    }

    public void setNumeroInscripción(int numeroInscripción) {
        this.numeroInscripción = numeroInscripción;
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

    public double getMontoAbonar() {
        return montoAbonar;
    }

    public void setMontoAbonar(double montoAbonar) {
        montoAbonar = montoAbonar;
    }

    public double calcularMontoAbonar() {
        if (categoria.getNombre() == "Circuito chico") {
            if (participante.getEdad() < 18) {
                montoAbonar = 1300;
            } else if (participante.getEdad() >= 18) {
                montoAbonar = 1500;
            }
        } else if (categoria.getNombre() == "Circuito medio") {
            if (participante.getEdad() < 18) {
                montoAbonar = 2000;
            } else if (participante.getEdad() >= 18) {
                montoAbonar = 2300;
            }
        } else if (categoria.getNombre() == "Circuito avanzado") {
            if (participante.getEdad() < 18) {
                montoAbonar = 0;
                System.out.println("Para inscribirse al circuito avanzado debe tener por lo menos 18 años.");
            } else if (participante.getEdad() >= 18) {
                montoAbonar = 2800;
            }
        }
    return montoAbonar;
    }
}
