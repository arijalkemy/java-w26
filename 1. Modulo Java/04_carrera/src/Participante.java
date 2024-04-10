public class Participante {
    
    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numEmergencia;
    private String grupoSanguineo;

    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String numEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni  = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getEdad() {
        return this.edad;
    }

    public boolean isMayor() {
        return this.edad >= 18;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Participante)) return false;
        Participante oParticipante = (Participante) other;
        return oParticipante.numero == this.numero;
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + this.numero + "'" +
            ", dni='" + this.dni + "'" +
            ", nombre='" + this.nombre + "'" +
            ", apellido='" + this.apellido + "'" +
            ", edad='" + this.edad + "'" +
            ", celular='" + this.celular + "'" +
            ", numEmergencia='" + this.numEmergencia + "'" +
            ", grupoSanguineo='" + this.grupoSanguineo + "'" +
            "}";
    }

    

}
