public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    // Constructor
    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    // Método para calcular el monto de la inscripción
    double calcularMonto() {
        double montoBase = 0;
        if (participante.getEdad() < 18) {
            switch (categoria.getId()) {
                case 1:  // Circuito chico
                    montoBase = 1300;
                    break;
                case 2:  // Circuito medio
                    montoBase = 2000;
                    break;
            }
        } else {
            switch (categoria.getId()) {
                case 1:  // Circuito chico
                    montoBase = 1500;
                    break;
                case 2:  // Circuito medio
                    montoBase = 2300;
                    break;
            }
        }
        return montoBase;
    }
}
