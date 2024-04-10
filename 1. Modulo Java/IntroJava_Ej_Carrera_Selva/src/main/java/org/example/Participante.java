package org.example;

public class Participante {

    private static final String[] NOMBRES = {"Pedro", "Jose", "Nicolas", "Ezequiel", "Mario"};
    private static final String[] APELLIDOS = {"Perez","Garcia","Rodriguez","Gonzalez","Messi"};
    private  static final int CANTIDAD_NOMBRES = NOMBRES.length;
    private static final int EDAD_MINIMA = 13;
    private static final int EDAD_MAXIMA = 87;
    private static final String[] GRUPOS_SANGUINEOS = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
    private static final int CANTIDAD_GRUPOS_SANGUINEOS = GRUPOS_SANGUINEOS.length;
    private static int CONTADOR = 0;
    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmergencia;
    private String grupoSanguineo;

    public Participante() {
         this(
                ++CONTADOR,
                CONTADOR,
                NOMBRES[(int) (Math.random() * CANTIDAD_NOMBRES)],
                APELLIDOS[(int) (Math.random() * CANTIDAD_NOMBRES)],
                (int) (Math.random() * EDAD_MAXIMA) + EDAD_MINIMA,
                (int) (Math.random() * 10000) + 1000,
                (int) (Math.random() * 10000) + 1000,
                GRUPOS_SANGUINEOS[(int) (Math.random() * CANTIDAD_GRUPOS_SANGUINEOS)]
                );
    }

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }



    @Override
    public String toString() {
        return "Participante{" +
                "numeroParticipante=" + numeroParticipante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
