package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoGrande = new Categoria(3, "Circuito Grande", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(1234567, 1, "Pablo", "Perez", "123456", 25, "12345", "A+" );

        Inscripcion inscripcion1 = Inscripcion.inscribirParticipante(participante1, circuitoChico);
    }
}