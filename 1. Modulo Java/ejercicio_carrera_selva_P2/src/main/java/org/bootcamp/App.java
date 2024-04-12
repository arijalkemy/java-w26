package org.bootcamp;

import org.bootcamp.domain.Categoria;
import org.bootcamp.domain.Inscripcion;
import org.bootcamp.domain.Participante;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jsanchezpimi
 */
public class App {
    // Declaracion de variables globales
    private static List<Categoria> categorias;
    private static List<Participante> participantes;
    private static List<Inscripcion> inscripciones;
    private static Scanner entrada;

    //Declaracion de constantes
    private static final int ID_CIRCUITO_CHICO = 1;
    private static final int ID_CIRCUITO_MEDIO = 2;
    private static final int ID_CIRCUITO_AVANZADO = 3;

    /**
     * Metodo principal de la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        //Se inicializan las listas y el scanner
        categorias = new ArrayList<>();
        participantes = new ArrayList<>();
        inscripciones = new ArrayList<>();
        entrada = new Scanner(System.in);

        // Se carga las categorias
        cargarCategorias();

        // Se carga y recorre el menu principal
        boolean salir = false;
        do {
            cargarMenu();
            salir = seleccionarOpcionMenu();
        } while (!salir);

    }

    /**
     * Metodo que carga el menu principal de la app
     */
    private static void cargarMenu() {
        imprimir("\n****** CARRERA DE LA SELVA - MENU ******\n");
        imprimir("1. Inscribir participante");
        imprimir("2. Inscribir participante al azar");
        imprimir("3. Mostrar participantes por categoría");
        imprimir("4. Desinscribir participante");
        imprimir("5. Calcular monto total recaudado");
        imprimir("6. Salir\n");
    }

    /**
     * Metodo que realiza la seleccion de la opcion a ejecutar el usuario
     * @return booleano con el valor si finaliza o no la aplicacion
     */
    private static boolean seleccionarOpcionMenu(){
        int opcion = capturarEntero("Selecciona una opción");
        switch (opcion){
            case 1:
                inscribirParticipante();
                return false;
            case 2:
                inscribirParticipanteAlAzar();
                return false;
            case 3:
                mostrarParticipantesPorCategoria(null);
                return false;
            case 4:
                desinscribirParticipante();
                return false;
            case 5:
                montoTotalRecaudado();
                return false;
            case 6:
                salir();
                return true;
            default:
                return false;
        }
    }

    /**
     * Metodo que inicializa el cargue de las categorias
     */
    private static void cargarCategorias(){
        categorias.add(new Categoria(ID_CIRCUITO_CHICO, "Circuito chico", "2 km por selva y arroyos"));
        categorias.add(new Categoria(ID_CIRCUITO_MEDIO,"Circuito medio", "5 km por selva, arroyos y barro"));
        categorias.add(new Categoria(ID_CIRCUITO_AVANZADO,"Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra"));
    }

    /**
     * Metodo que imprime un texto por consola
     * @param texto de tipo String a imprimir
     */
    private static void imprimir(String texto){
        System.out.println(texto);
    }

    /**
     * Metodo que imprime un texto por consola sin salto de linea
     * @param texto de tipo String a imprimir
     */
    private static void imprimirSinSalto(String texto){
        System.out.print(texto);
    }

    /**
     * Metodo que realiza la captura de un campo en valor entero
     * @param campo de tipo String
     * @return entero con el valor capturado
     */
    private static int capturarEntero(String campo){
        int valor = 0;
        do{
            imprimirSinSalto(campo + ": ");
            valor = entrada.nextInt();
            entrada.nextLine();// Se Limpia el buffer del scanner

            // Se valida que el valor capturado sea mayor que 0, sino genera la alerta
            if(valor < 0)
                imprimir("El valor no puede ser menor o igual que 0, intente de nuevo por favor.");

        }while(valor < 0);
        return valor;
    }

    /**
     * Metodo que realiza la captura de un campo en valor String
     * @param campo de tipo String
     * @return String con el valor capturado
     */
    private static String capturarString(String campo){
        imprimirSinSalto(campo + ": ");
        return entrada.nextLine();
    }

    /**
     * Metodo con una opcion del menu principal para inscribir un participante
     */
    private static void inscribirParticipante(){
        imprimir("\n--- Ingrese los datos del Participante ---\n");
        int dni = 0;

        //Se valida que no exista el participante ya inscrito
        do{
            dni = capturarEntero("DNI");
        }while(noEsValidoParticipante(dni, false));

        //Se captura y guarda la informacion del participante, categoria e inscripcion
        Participante participante = capturarInformacionParticipante(dni);
        participantes.add(participante);
        Categoria categoria = seleccionarCategoria(participante);

        realizarInscripcion(participante, categoria);

        imprimir("\n¡Participante inscrito correctamente!");
    }

    /**
     * Metodo que valida si ya se encuentra inscrito un participante
     * con el dni en la lista de participantes
     * @param dni del participante a validar
     * @param esAzar valor booleano que determina si es un participante al azar
     * @return valor booleano si se encuentra el participante ya inscrito
     */
    private static boolean noEsValidoParticipante(int dni, boolean esAzar){
        for(Participante participante: participantes){
            if(participante.getDni() == dni){
                if(!esAzar){
                    imprimir("\n\nEl participante con el DNI " + dni
                            + " ya se encuentra inscrito, intente de nuevo.\n");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que captura la información del participante
     * @param dni valor entero
     * @return participante con la informacion capturada
     */
    private static Participante capturarInformacionParticipante(int dni){
        return new Participante(
                participantes.size() + 1,
                dni,
                capturarString("Nombre"),
                capturarString("Apellido"),
                capturarEntero("Edad"),
                capturarString("Celular"),
                capturarString("Número de emergencia"),
                capturarString("Grupo sanguíneo")
        );
    }

    /**
     * Metodo que selecciona una categoria y valida que el participante no sea
     * menor de edad si el circuito es el avanzado
     * @param participante
     * @return categoria seleccionada
     */
    private static Categoria seleccionarCategoria(Participante participante){
        int opcion;

        //Se imprime la información de las opciones de las categorias
        imprimir("\n--- Seleccione la categoría ---\n");
        for(int i = 0; i < categorias.size(); i++)
            imprimir((i + 1) + ". " + categorias.get(i).getNombre()) ;

        do{
            opcion = capturarEntero("Ingrese la opción");

            //Si la opcion ingresada no es valida, se vuelve a solicitar la categoria
            if(opcion < 1 || opcion > 3)
                imprimir("\nOpción ingresada no valida, por favor intente de nuevo\n");

            //se valida que no sea menor de edad si es la opcion es la 3
            if(opcion == 3 && participante != null && participante.getEdad() < 18){
                opcion = 0;
                imprimir("\nNo se acepta a menores de 18 años en la categoría seleccionada, por favor seleccione otra.\n");
            }

        }while(opcion < 1 || opcion > 3);

        return categorias.get(--opcion);//Se obtiene la opción anterior a la diligenciada ej. 3 - 1 = 2
    }

    /**
     * Metodo que calcula el monto de acuerdo a la edad del participante y la cateogria
     * a inscribir
     * @param participante
     * @param categoria
     * @return valor double con el monto calculado
     */
    private static double calcularMonto(Participante participante, Categoria categoria){
        if(categoria.getId() == ID_CIRCUITO_CHICO )
            return (participante.getEdad() < 18) ? 1300 : 1500;

        if(categoria.getId() == ID_CIRCUITO_MEDIO)
            return (participante.getEdad() < 18) ? 2000 : 2300;

        return 2800;
    }

    /**
     * Metodo que inscribe un participante al azar en el menu principal
     */
    private static void inscribirParticipanteAlAzar(){
        Random random = new Random();
        imprimir("\n--- Inscripción de Participante al Azar ---\n");

        //Se establecen los nombres,apellidos y grupo sanguineos a utilizar al azar
        String[] nombres = {"Juan", "Pedro", "María", "Ana", "Luis", "Laura", "Diego", "Carolina", "Javier", "Fernanda"};
        String[] apellidos = {"González", "López", "Martínez", "Rodríguez", "Gómez", "Pérez", "Sánchez", "Díaz"};
        String[] gruposSanguineos = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

        int dni;
        do{
            dni = random.nextInt(1000);
        } while (noEsValidoParticipante(dni, true));

        Participante participante = new Participante(
            participantes.size() + 1,
            dni,
            nombres[random.nextInt(nombres.length)],
            apellidos[random.nextInt(apellidos.length)],
            random.nextInt(60),
            "" + random.nextInt(9999999),
            "" + random.nextInt(9999999),
            gruposSanguineos[random.nextInt(gruposSanguineos.length)]);

        participantes.add(participante);

        Categoria categoria = categorias.get(random.nextInt(categorias.size()));

        if(participante.getEdad() < 18 && categoria.getId() == ID_CIRCUITO_AVANZADO)
            categoria = categorias.get(random.nextInt(categorias.size() - 1));

        realizarInscripcion(participante, categoria);

        //Se imprime la informacion del participante registrado
        imprimir(participante.toString());
        imprimir(categoria.toString());
        imprimir("\n¡Participante inscrito al azar correctamente!");
    }

    /**
     * Metodo que realiza el guardadi de inscripcion en la lista de inscripciones
     * @param participante
     * @param categoria
     */
    private static void realizarInscripcion(Participante participante, Categoria categoria){
        inscripciones.add(new Inscripcion(
                inscripciones.size() + 1,
                categoria,
                participante,
                calcularMonto(participante, categoria)));
    }

    /**
     * Metodo que muestra la informacion de los participante asociados a una categoria seleccionada
     * @param idCategoria valor Integer de la categoria a mostrar
     */
    private static void mostrarParticipantesPorCategoria(Integer idCategoria){
        imprimir("\n--- Mostrar Participantes por Categoría ---");
        Categoria categoria;
        if(idCategoria == null){
            categoria = seleccionarCategoria(null);
        }else{
            categoria = categorias.get(idCategoria);
        }

        // Se realiza la validacion de las inscripciones por categorias y se imprime la informacion
        inscripciones.stream().filter((inscripcion) -> inscripcion.getCategoria().equals(categoria))
                .forEach((inscripcion)->{
                    imprimir("\nnúmero de inscripción: " + inscripcion.getNumeroInscripcion());
                    imprimir(inscripcion.getParticipante().toString());
                });
    }

    /**
     * Metodo principal que desinscribe un participante
     */
    private static void desinscribirParticipante(){
        imprimir("\n--- Desinscribir Participantes ---\n");
        Participante participante = seleccionarParticipante();

        // Se actualiza el numero de los participantes
        actualizarNumeroParticipantes(participante);

        Inscripcion inscripcion = inscripciones.stream().filter((insc)-> insc.getParticipante() == participante)
                .findFirst().orElse(null);

        if(inscripcion == null){
            imprimir("\nNo se encontro la inscripción del participante con el número de participación " +  participante.getNumeroParticipante());
        }else{
            // Se elimina el objeto de la lista de participantes
            participantes.remove(participante);
            // Se elimina el objeto de la lista de inscripciones
            inscripciones.remove(inscripcion);
            mostrarParticipantesPorCategoria(Integer.valueOf(inscripcion.getCategoria().getId()));
        }

    }

    /**
     * Metodo que selecciona un participante de acuerdo al numero del participante
     * y retorna solamente al participante si se encuentra inscrito
     * @return participante
     */
    private static Participante seleccionarParticipante(){
        Participante participanteSeleccionado = null;
        int idParticipante = 0;
        boolean noExisteParticipante = true;

        do{
            idParticipante = capturarEntero("Ingrese el número del participante");

            for(Participante participante : participantes){
                if(participante.getNumeroParticipante() == idParticipante){
                    participanteSeleccionado = participante;
                    noExisteParticipante = false;
                    break;
                }
            }

            if(noExisteParticipante)
                imprimir("No existe el participante, intente de nuevo.\n");

        } while (noExisteParticipante);

        return participanteSeleccionado;
    }

    /**
     * Metodo que actualiza los numeros de los participantes despues de haber
     * sido desinscrito uno de la lista de participantes
     * @param participante a eliminar de la lista
     */
    private static void actualizarNumeroParticipantes(Participante participante){
        int numeroParticipante = participante.getNumeroParticipante();

        for (int i = numeroParticipante; participantes.size() < i; i++){
            Participante participanteActualizar = participantes.get(i);
            participanteActualizar.setNumeroParticipante(numeroParticipante);
        }
    }

    /**
     * Metodo principal que realiza el calculo del monto total recaudado por
     * categoria y por todos
     */
    private static void montoTotalRecaudado(){
        imprimir("\n--- Monto total recaudado ---\n");
        double montoTotal = 0D;
        for (Categoria categoria : categorias) {
            montoTotal += montoTotalPorCategoria(categoria);
        }

        imprimir("\n\nMonto total recaudado de todas las categorías: $" + montoTotal);
    }

    /**
     * Metodo que realiza el calculo del monto total de una categoria
     * @param categoria a realizar el calculo del monto total
     * @return monto total recaudado de la categoria
     */
    private static double montoTotalPorCategoria(Categoria categoria){
        imprimir("\n** " + categoria.getNombre() + " **\n");
        double montoTotal = 0D;

        List<Inscripcion> inscripcionesCategoria = inscripciones.stream().filter((inscripcion -> inscripcion.getCategoria() == categoria))
                .collect(Collectors.toList());

        for(Inscripcion inscripcion : inscripcionesCategoria){
            montoTotal += inscripcion.getMonto();
        }

        imprimir("El monto total recaudado: $" +montoTotal);

        return montoTotal;
    }

    /**
     * Metodo principal que imprime el mensaje final del programa
     */
    private static void salir(){
        imprimir("\n****** ¡HASTA LUEGO! ******\n");
        imprimir("****** FIN DEL PROGRAMA - CARRERA DE LA SELVA******");
    }

}
