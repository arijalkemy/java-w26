package org.example;

public class Cliente {
    private String nome;
    private int edad;
    private String dni;

    public Cliente(String nome, int edad, String dni) {
        this.nome = nome;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
