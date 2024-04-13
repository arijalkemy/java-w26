import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Punto A - Crear 3 Objetos de tipo Categoria
        Categoria cat1 = new Categoria(0,"Circuito chico", "2 km por selva y arroyos");
        Categoria cat2 = new Categoria(1,"Circuito medio", "5 km por selva, arroyos y barro");
        Categoria cat3 = new Categoria(2,"Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        List<Participante> participantes = new ArrayList<Participante>();

        // Punto B y C - Crear nuevo participante e inscribirlos en diferentes categorias.
        Participante par1 = new Participante(0,123, "Juan Perez", 17, "12342343", "123", "A+", cat1);
        Participante par2 = new Participante(1,456, "Maria Becerra", 21, "45654353", "456", "B+", cat2);
        Participante par3 = new Participante(3,789, "Mariano Martinez", 25, "7894353", "789", "O-", cat3);
        Participante par4 = new Participante(2,876,"Juan Carlos",43,"11423523","787", "B+", cat1);

        par1.inscribirInscripcion();
        par2.inscribirInscripcion();
        par3.inscribirInscripcion();
        par4.inscribirInscripcion();

        participantes.add(par1);
        participantes.add(par2);
        participantes.add(par3);
        participantes.add(par4);

        // Punto D - Mostrar por pantalla los inscriptos a una determinada categoria
        System.out.println("////////////////////////////");
        System.out.println("-------- Punto D - Mostrar por pantalla inscriptos a determinada categoria ---------");
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("1. Ver Participantes Circuito Chico");
                System.out.println("2. Ver Participantes Circuito Medio");
                System.out.println("3. Ver Participantes Circuito Avanzado");
                System.out.println("4. Salir, para continuar con la siguiente consigna solicitada.");
                System.out.print("Por favor, elige una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("//// Listado de participantes Categoria Circuito Chico");
                        for (Participante part : participantes) {
                            if (part.categoria.equals(cat1)) {
                                /*System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.nombre);
                                System.out.println("Nro Inscripcion: " + part.nro_de_participante);
                                System.out.println("Edad: " + part.edad);
                                System.out.println("Celular: " + part.celular);
                                System.out.println("Grupo sanguineo: " + part.grupo_sanguineo);
                                System.out.println("------------------");*/
                                System.out.println(part.toString());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("//// Listado de participantes Categoria Circuito Medio");
                        for (Participante part : participantes) {
                            if (part.categoria.equals(cat2)) {
                                /*System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.nombre);
                                System.out.println("Nro Inscripcion: " + part.nro_de_participante);
                                System.out.println("Edad: " + part.edad);
                                System.out.println("Celular: " + part.celular);
                                System.out.println("Grupo sanguineo: " + part.grupo_sanguineo);
                                System.out.println("------------------");*/
                                System.out.println(part.toString());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("//// Listado de participantes Categoria Circuito Avanzado");
                        for (Participante part : participantes) {
                            if (part.categoria.equals(cat3)) {
                                /*System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.nombre);
                                System.out.println("Nro Inscripcion: " + part.nro_de_participante);
                                System.out.println("Edad: " + part.edad);
                                System.out.println("Celular: " + part.celular);
                                System.out.println("Grupo sanguineo: " + part.grupo_sanguineo);
                                System.out.println("------------------");*/
                                System.out.println(part.toString());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
                }
            } while (opcion != 4);

        System.out.println("////////////////////////////");
        System.out.println("-------- Punto E - Desinscribir participante en una categoria y mostrarla en pantalla---------");

        // Punto E - Desinscribir Participante en Categoria 1
        par4.desinscribirParticipante();
        for(Participante par : participantes){
            if (par.inscripto && par.categoria.id == 0){
                System.out.println(par.toString());
                System.out.println("\n");
            }
        }

        //Punto F - Calcular monto total por categoria
        System.out.println("------- Punto F - Calcular recaudacion por categoria -------");
        int recaudadoCat1 = 0;
        int recaudadoCat2 = 0;
        int recaudadoCat3 = 0;

        for (Participante p : participantes){
            if(p.inscripto && p.categoria.id==0){
                recaudadoCat1 += p.inscribirInscripcion();
            }
            if(p.inscripto && p.categoria.id == 1){
                recaudadoCat2 += p.inscribirInscripcion();
            }
            if(p.inscripto && p.categoria.id == 2){
                recaudadoCat3 += p.inscribirInscripcion();
            }
        }
        System.out.println("Categoria Circuito Chico ha recaudado: " + recaudadoCat1);
        System.out.println("Categoria Circuito Medio ha recaudado: " + recaudadoCat2);
        System.out.println("Categoria Circuito Avanzado ha recaudado: " + recaudadoCat3);

    }

}