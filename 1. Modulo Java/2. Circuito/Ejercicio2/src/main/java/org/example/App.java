package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main(String[] args )
    {
        Categoria chico = new Categoria(1,"Circuito Chico", "2km por selva y arroyos");
        Categoria medio = new Categoria(2,"Circuito Medio","5 km por selva, arroyos y barro");
        Categoria avanzado = new Categoria(3,"Circuito Avanzado","10 km por selva, arroyos, barro y escalada en piedra.");





        Participante joaquin = new Participante(1,41152547,"Joaquin","Gual",25,"351234566","3513456782","AB+");
        Participante julieta = new Participante(2,40222333,"Julieta","Garcia",25,"351234556","3513236782","A+");
        Participante luciano = new Participante(3,39152547,"Luciano","De la rubia",17,"351232266","3513454282","A+");

        Inscripcion inscripcion1 = new Inscripcion(1,joaquin,chico);
        Inscripcion inscripcion2 = new Inscripcion(2,julieta,medio);
        Inscripcion inscripcion3 = new Inscripcion(3,luciano,medio);

        Map<Integer, Inscripcion> inscriptos = new HashMap<>();

        inscriptos.put(1,inscripcion1);
        inscriptos.put(2,inscripcion2);
        inscriptos.put(3,inscripcion3);


        Map<Integer, Inscripcion> circuitoChico = new HashMap<>();
        Map<Integer, Inscripcion> circuitoMedio = new HashMap<>();
        Map<Integer, Inscripcion> circuitoAvanzado = new HashMap<>();

        double montoTotalCategorias = 0;
        for (Map.Entry<Integer,Inscripcion> i : inscriptos.entrySet()) {

            Inscripcion inscripto = i.getValue();
            montoTotalCategorias += inscripto.getMonto();

            switch (inscripto.getCategoria().getId()){
                case 1:
                    circuitoChico.put(i.getKey(),inscripto);
                    break;
                case 2:
                    circuitoMedio.put(i.getKey(),inscripto);
                    break;
                case 3:
                    circuitoAvanzado.put(i.getKey(),inscripto);
                    break;
            }
        }


        System.out.println("***********************************");
        System.out.println("Inscriptos a Circuito Chico");

        double montoTotalChico = mostrarInscriptosXCategoria(circuitoChico);

        System.out.println("***********************************");
        System.out.println("Inscriptos a Circuito Medio");

        double montoTotalMedio = mostrarInscriptosXCategoria(circuitoMedio);

        System.out.println("***********************************");
        System.out.println("Inscriptos a Circuito Avanzado");

        double montoTotalAvanzado = mostrarInscriptosXCategoria(circuitoAvanzado);

        //Desinscribir a un participante






        //Monto total recaudado por categoria Medio
        System.out.println("Monto total recaudado en el Circuito Chico: " + montoTotalChico);
        System.out.println("Monto total recaudado en el Circuito Medio: " + montoTotalMedio);
        System.out.println("Monto total recaudado en el Circuito Medio: " + montoTotalAvanzado);
        System.out.println("Monto total recaudado en todas las categorias: " + montoTotalCategorias );


    }

    private static double mostrarInscriptosXCategoria(Map<Integer, Inscripcion> mapInscriptosXCat) {
        double montoXCat = 0;
        for (Map.Entry<Integer,Inscripcion> i : mapInscriptosXCat.entrySet()) {

            Inscripcion inscriptoCat = i.getValue();
            montoXCat += inscriptoCat.getMonto();
            System.out.println("_____________________________");
            System.out.println("Numero de Inscripcion: " + inscriptoCat.getId());
            System.out.println("Numero de participante: " + inscriptoCat.getParticipante().getNroParticipante());
            System.out.println("Nombre y Apellido: " + inscriptoCat.getParticipante().getNombre() + " " + inscriptoCat.getParticipante().getApellido());
            System.out.println("Dni: " + inscriptoCat.getParticipante().getDni());
            System.out.println("Edad: " + inscriptoCat.getParticipante().getEdad());
            System.out.printf("Celular: " + inscriptoCat.getParticipante().getCelular());
            System.out.println("\nGrupo Sanguineo: " + inscriptoCat.getParticipante().getGrupoSanguineo());
            System.out.println("Numero de emergencia:" + inscriptoCat.getParticipante().getNumeroEmergencia());
            System.out.println("Monto Abonado: " + inscriptoCat.getMonto());
            System.out.println("_____________________________");
        }
        return montoXCat;
    }


}


