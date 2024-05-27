package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //a)
        Categoria chico= new Categoria(1,"Circuito chico","2 km por selva y arroyos.");
        Categoria medio= new Categoria(2,"Circuito medio","5 km por selva, arroyos y barro.");
        Categoria avanzado= new Categoria(3,"Circuito avanzado","10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(1, "12345678A", "Juan", "Pérez", 30, 987654321, 999888777, "AB+");
        Participante participante2 = new Participante(2, "87654321B", "María", "Gómez", 17, 654321987, 777888999, "A-");
        Participante participante3 = new Participante(3, "13579246C", "Carlos", "Martínez", 35, 741852963, 888999777, "O+");
        Participante participante4 = new Participante(4, "98765432D", "Laura", "López", 15, 369258147, 555666444, "B+");
        Participante participante5 = new Participante(5, "24680135E", "Ana", "Sánchez", 32, 852963741, 333222111, "AB-");


        Set<Inscripcion> repoInscripciones =  new HashSet<>();
        repoInscripciones.add(new Inscripcion(chico,participante1));
        repoInscripciones.add(new Inscripcion(chico,participante2));
        repoInscripciones.add(new Inscripcion(medio,participante3));
        repoInscripciones.add(new Inscripcion(medio,participante4));
        repoInscripciones.add(new Inscripcion(avanzado,participante5));

        for (Inscripcion e: repoInscripciones) {
            System.out.println(e.getMonto());

        }
        repoInscripciones.stream().forEach(inscripcion -> {
            System.out.println(inscripcion.getCategoria().getNombre()+" "+inscripcion.getParticipante().getNombre()+" "+inscripcion.getParticipante().getApellido());
        });

        repoInscripciones.removeIf(inscripcion -> {
            return inscripcion.getParticipante().getNombre().equals("Juan");
        });

        repoInscripciones.forEach(inscripcion -> {
            System.out.println(inscripcion.getParticipante().getNombre());
        });
        Integer monto= 0;

       System.out.println(repoInscripciones.stream().map(inscripcion -> inscripcion.getMonto()).mapToInt(Integer::intValue).sum());
        Persona personaNoArgs = new Persona();
        Persona personaReqArgs = new Persona("Hola",13,"asdaww");
        Persona personaAllArgs = new Persona("Yair",27,"212",69,169);

        System.out.println(personaReqArgs.getIMC());
        Integer IMC = personaAllArgs.getIMC();

        if(IMC == -1){
            System.out.println("IMC Bajo");
        }
        if(IMC == 0){
            System.out.println("IMC Saludable");
        }
        if(IMC == 1){
            System.out.println("Gordo");
        }
        personaReqArgs.isMayor();
        System.out.println(personaNoArgs.toString());
        System.out.println(personaReqArgs.toString());
        System.out.println(personaAllArgs.toString());

    }
}
