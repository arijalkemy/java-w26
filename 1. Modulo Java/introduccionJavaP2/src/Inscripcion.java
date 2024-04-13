public class Inscripcion {

    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto(categoria, participante.getEdad());
    }

    private double calcularMonto(Categoria categoria, int edad ){
       switch (categoria.getNombre()){
           case "chico":{
               return edad < 18 ? 1300 : 1500;
           }
           case "medio":{
               return edad < 18 ? 2000 : 2300;
           }
           case "avanzado":{
               if(edad < 18){
                   throw new IllegalArgumentException("La edad no puede ser menor de 18 para la categoria Avanzado ");
               }
               return 2800;
           }
           default: throw new IllegalArgumentException("Deberia escoger una de las categorias");
       }

    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}

