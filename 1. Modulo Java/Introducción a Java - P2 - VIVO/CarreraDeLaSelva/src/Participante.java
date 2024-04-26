public class Participante {

    private int numeroParticipante;
    private String dni;
    private String nombre;
    private String apellido;

    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguíneo;

    public Participante(int numeroParticipante, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguíneo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguíneo = grupoSanguíneo;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguíneo() {
        return grupoSanguíneo;
    }

    public void setGrupoSanguíneo(String grupoSanguíneo) {
        this.grupoSanguíneo = grupoSanguíneo;
    }
}
