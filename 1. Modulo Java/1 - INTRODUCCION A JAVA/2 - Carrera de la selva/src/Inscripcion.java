public class Inscripcion {
    private int numeroInscripcion;
    private String nombre;
    private Participante participante;
    private Categoria categoria;
    private double montoAPagar;
    private String errorInscripcion;


    public Inscripcion(int numeroInscripcion, String nombre, Participante participante, Categoria categoria) throws Exception {
        this.numeroInscripcion = numeroInscripcion;
        this.nombre = nombre;
        this.participante = participante;
        this.categoria = categoria;

        // Verificar si la categoría es "CircuitoAvanzado" y el participante tiene menos de 18 años
        if (categoria.getMinimaEdadRequerida() != null && participante.getEdad() < categoria.getMinimaEdadRequerida()) {
            throw new Exception("No se pueden inscribir al participante " +
                    participante.getNombre() + " " + participante.getApellido() +
                    " ya que no se aceptan menores de 18 años en la cateogoria " +
                    categoria.getNombre()
            );
        }

        setMontoAPagar(participante, categoria);
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {

        this.numeroInscripcion = numeroInscripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMontoAPagar(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public void setErrorInscripcion(String errorInscripcion) {
        this.errorInscripcion = errorInscripcion;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Participante getParticipante() {
        return participante;
    }

    public String getErrorInscripcion() {
        return errorInscripcion;
    }

    public void setMontoAPagar(Participante participante, Categoria categoria) {
        switch (categoria.getNombre()){
            case "CircuitoChico":
                if (participante.getEdad() < 18 ) {
                    this.montoAPagar = 1300;
                }
                else {
                    this.montoAPagar = 1500;
                }
                break;
            case "CircuitoMedio":
                if (participante.getEdad() < 18 ) {
                    this.montoAPagar = 2000;
                }
                else {
                    this.montoAPagar = 2300;
                }
                break;
            case "CircuitoAvanzado":
                if (categoria.getMinimaEdadRequerida() != null && participante.getEdad() > categoria.getMinimaEdadRequerida()){
                    this.montoAPagar = 2800;
                }
                break;
        }
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

}
