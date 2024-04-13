public class Participante {
    public int nro_de_participante;
    public long dni; 
    public String nombre_apellido;
    public int edad;
    public String celular; 
    public String nro_de_emergencia;
    public String grupo_sanguineo;
    public Categoria categoria;

    public Boolean inscripto = false;

    public Participante(int nro_de_participante, long dni, String nombre_apellido, int edad, String celular, String nro_de_emergencia, String grupo_sanguineo, Categoria categoria) {
        this.nro_de_participante = nro_de_participante;
        this.dni = dni;
        this.nombre_apellido = nombre_apellido;
        this.edad = edad;
        this.celular = celular;
        this.nro_de_emergencia = nro_de_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
        this.categoria = categoria;
    }

    public int inscribirInscripcion(){
        switch(this.categoria.id){
            case 0: if(this.edad<18){
                inscripto = true;
                return 1300;
            }else{
                inscripto = true;
                return 1500;
            }
            case 1: if(this.edad<18){
                inscripto = true;
                return 2000;
            }else{
                inscripto = true;
                return 2300;
            }
            case 2: if(this.edad<18){
                inscripto = false;
                return 0;
            }else{
                inscripto = true;
                return 2800;
            }
            default: return 0;
        }
    }
    public void desinscribirParticipante(){
        this.inscripto = false;
    }

    @Override
    public String toString() {
        return "Participante: "+ nombre_apellido + " {" +
                "nro_de_participante=" + nro_de_participante +
                ", dni=" + dni +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", nro_de_emergencia='" + nro_de_emergencia + '\'' +
                ", grupo_sanguineo='" + grupo_sanguineo + '\'' +
                ", categoria=" + categoria +
                ", inscripto=" + inscripto +
                '}';
    }
}
