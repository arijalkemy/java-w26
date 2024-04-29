package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    //Atributos
    private static List<Map<String,Object>> carrera_selva = new ArrayList<Map<String,Object>>();

    private static List<Map<String,Object>> participantes_Circuito_chico = new ArrayList<Map<String,Object>>();
    private static List<Map<String,Object>> participantes_Circuito_medio = new ArrayList<Map<String,Object>>();
    private static List<Map<String,Object>> participantes_Circuito_avanzado = new ArrayList<Map<String,Object>>();
    //Control de id de inscripciones
    private static int id_inscripcion=1;
    private static int total_circuito_chico=0;
    private static int total_circuito_medio=0;
    private static int total_circuito_avanzado=0;
    //Estructura Lista de tipo set para evitar el duplicado de registros de usuarios
    private static Set<String> participantes = new HashSet<>();

    public static void main( String[] args )
    {
        System.out.println("___________________________________________");
        //a)Crear 3 objetos de tipo categoría (uno por cada categoria) con sus respectivos datos.

        //Asignacion de los datos de cada carrera
        carrera_selva.add(asignarDatosCarrera("Circuito chico", "2 km","Selva y arroyos",participantes_Circuito_chico));
        carrera_selva.add(asignarDatosCarrera("Circuito medio", "5 km por selva","Selva, arroyos y barro",participantes_Circuito_medio));
        carrera_selva.add(asignarDatosCarrera("Circuito avanzado", "10 km por selva","Selva, arroyos, barro y escalada en piedra",participantes_Circuito_avanzado));

        //b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500)
        //Verificacion del usuario en el sistema
        if(!verificacionInscripcion("123")){
            //creacion del usuario
            Map<String, String> participante_1 = asignarDatosParticipante("123", "Cristian", "Torres", "17", "3017351346", "3017351347", "B+");
            //Seleccion categoria y abono
            int datos[] = seleccionarInscripcion("17");
            //Inscripcion
            Map<String, Object> inscripcion = asignarDatosInscripcion(participante_1, datos[1]);
            asignarCompeticion(inscripcion, datos[0]);
        }
        //c)Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        //Inscripcion 2
        Map<String, String> participante_2 = asignarDatosParticipante("1234", "Andres", "Torre", "30", "3027351341", "3027351342", "B+");
        int datos_2[] = seleccionarInscripcion("30");
        Map<String, Object> inscripcion_2 = asignarDatosInscripcion(participante_2, datos_2[1]);
        asignarCompeticion(inscripcion_2, datos_2[0]);
        //Inscripcion 3
        Map<String, String> participante_3 = asignarDatosParticipante("12345", "Estefan", "Chaparro", "15", "3037351341", "3037351342", "B+");
        int datos_3[] = seleccionarInscripcion("15");
        Map<String, Object> inscripcion_3 = asignarDatosInscripcion(participante_3, datos_3[1]);
        asignarCompeticion(inscripcion_3, datos_3[0]);
        //Inscripcion 4
        Map<String, String> participante_4 = asignarDatosParticipante("123456", "Esteban", "Corto", "19", "3047351341", "3047351342", "B+");
        int datos_4[] = seleccionarInscripcion("19");
        Map<String, Object> inscripcion_4 = asignarDatosInscripcion(participante_4, datos_4[1]);
        asignarCompeticion(inscripcion_4, datos_4[0]);
        //Inscripcion 5
        Map<String, String> participante_5 = asignarDatosParticipante("1234567", "Camilo", "Corto", "29", "3057351341", "3057351342", "B+");
        int datos_5[] = seleccionarInscripcion("29");
        Map<String, Object> inscripcion_5 = asignarDatosInscripcion(participante_5, datos_5[1]);
        asignarCompeticion(inscripcion_5, datos_5[0]);

        Map<String, String> participante_6 = asignarDatosParticipante("12345678", "Camila", "Coco", "50", "3057351341", "3057351342", "B+");
        Map<String, Object> inscripcion_6 = asignarDatosInscripcion(participante_6, 2800);
        asignarCompeticion(inscripcion_6, 5);

        //d)Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        mostrarCategoria();

        //f) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        calcularMontoTotal();

        //e)Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        eliminarInscripcion(participantes_Circuito_avanzado, 6);

        //f) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        calcularMontoTotal();
    }

    //Permite asignar los datos a cada una de las carreras
    public static Map<String,Object> asignarDatosCarrera(String nombre_circuito, String tamgno_pista,String desc_pista, List<Map<String,Object>> participantes){
        Map<String,Object> circuito = new HashMap<>();
        circuito.put("nombre_circuito", nombre_circuito);
        circuito.put("tamgno_pista", tamgno_pista);
        circuito.put("desc_pista", desc_pista);
        circuito.put("lista_inscripcion", participantes);
        return circuito;
    }

    //Generacion de una inscripcion
    public static Map<String, Object> asignarDatosInscripcion(Map<String, String> participante, int abono){
        System.out.println("Generando inscripcion con id."+id_inscripcion);
        Map<String,Object> inscripcion = new HashMap<>();
        inscripcion.put("id_inscripcion", id_inscripcion);
        inscripcion.put("participante", participante);
        inscripcion.put("abono", abono);
        id_inscripcion ++;
        return inscripcion;
    }
    //Asigna una inscripcion a una competicion
    public static void asignarCompeticion(Map<String, Object> inscripcion, int categoria){
        switch (categoria){
            case 1:
                total_circuito_chico = total_circuito_chico + 1300;
                participantes_Circuito_chico.add(inscripcion);
                break;
            case 3:
                total_circuito_chico = total_circuito_chico + 1500;
                participantes_Circuito_chico.add(inscripcion);
                break;
            case 2:
                total_circuito_medio = total_circuito_medio + 2000;
                participantes_Circuito_medio.add(inscripcion);
                break;
            case 4:
                total_circuito_medio = total_circuito_medio + 2300;
                participantes_Circuito_medio.add(inscripcion);
                break;
            case 5:
                total_circuito_avanzado = total_circuito_avanzado + 2800;
                participantes_Circuito_avanzado.add(inscripcion);
                break;
        }
        System.out.println("Proceso exitoso...");
    }

    //Asigna los datos del participante
    public static Map<String, String> asignarDatosParticipante(String dni,String nombre,String apellido, String edad,
                                                               String celular, String numero_emergencia, String grupo_sanguineo){
        System.out.println("Creando participante....");
        Map<String,String> participante = new HashMap<>();
        participante.put("dni", dni);
        participante.put("nombre", nombre);
        participante.put("apellido", apellido);
        participante.put("edad", edad);
        participante.put("celular", celular);
        participante.put("numero_emergencia", numero_emergencia);
        participante.put("grupo_sanguineo", grupo_sanguineo);
        participantes.add(dni);
        return participante;
    }

    //Verifica la inscripcion de un usuario
    public static boolean verificacionInscripcion(String dni){
        if(participantes.contains(dni)){
            System.out.println("Participante con dni: "+dni+ " ya esta inscrito");
            return true;
        }else{
            System.out.println("El deportista con dni: "+dni+ " no esta inscrito");
            return false;
        }
    }

    //Seleccion inscripcion del usuario
    public static int[] seleccionarInscripcion(String edad){
        System.out.println("___________________________________________");
        System.out.println("El deportista se puede inscribir a:");
        int edad_num = Integer.parseInt(edad);
        int opcion [] = new int[2];
        Random random = new Random();
        if(edad_num>1 && edad_num< 18){
            System.out.println("1) Inscripción Circuito chico: $1300.");
            System.out.println("2) Inscripción Circuito medio: $2000.");
            opcion[0] = random.nextInt(2) + 1;
        }else if(edad_num>=18){
            System.out.println("3) Inscripción Circuito chico: $1500.");
            System.out.println("4) Inscripción Circuito medio: $2300.");
            System.out.println("5) Inscripción Circuito Avanzado: $2800");
            opcion[0] = random.nextInt(3) + 3;
        }
        switch (opcion[0]){
            case 1:
                System.out.println("Se inscfribio a Circuito chico, transaccion de $1300.");
                opcion[1] = 1300;
                break;
            case 2:
                System.out.println("Se inscfribio a Circuito medio, transaccion de $2000.");
                opcion[1] = 2000;
                break;
            case 3:
                System.out.println("Se inscfribio a Circuito chico, transaccion de $1500.");
                opcion[1] = 1500;
                break;
            case 4:
                System.out.println("Se inscfribio a Circuito medio, transaccion de $2300.");
                opcion[1] = 2300;
                break;
            case 5:
                System.out.println("Se inscfribio a Circuito Avanzado, transaccion de $2800.");
                opcion[1] = 2800;
                break;
        }
        System.out.println("_______________________________________________________");
        return opcion;
    }

    //Recorrer y mostrar datos de todas las categorias
    public static void mostrarCategoria(){
        System.out.println("_________________________________________");
        System.out.println("------------Data set carrera-------------");
        System.out.println("_________________________________________"+"\n");
        for (Map<String, Object> map_carrera_selva : carrera_selva) {
            for (Map.Entry<String, Object> datos_carrera_selva : map_carrera_selva.entrySet()) {
                String clave = datos_carrera_selva.getKey();
                Object valor = datos_carrera_selva.getValue();
                System.out.println(clave+":"+valor);
                if(clave == "lista_inscripcion"){
                    List<Map<String,Object>> lista_participantes = (List<Map<String,Object>>) valor;
                    for (Map<String, Object> map_lista_participantes : lista_participantes) {
                        for (Map.Entry<String, Object> detalle_lista_participantes : map_lista_participantes.entrySet()) {
                            String clave1 = detalle_lista_participantes.getKey();
                            Object valor2 = detalle_lista_participantes.getValue();
                            System.out.println(clave1+":"+valor2);
                        }
                    }
                }

            }
            System.out.println("_______________________________________________________"+"\n");
        }

    }

    //Monto total por competicion
    public static void calcularMontoTotal(){
        System.out.println("________________Total Inscripcion________________________"+"\n");
        System.out.println("Total circuito chico: "+total_circuito_chico);
        System.out.println("Total circuito medio: "+total_circuito_medio);
        System.out.println("Total circuito avanzado: "+total_circuito_avanzado);
        System.out.println("Total: "+(total_circuito_avanzado+total_circuito_medio+total_circuito_chico));

    }

    //Eliminar una inscripcion
    public static void eliminarInscripcion(List<Map<String,Object>> participantes, int id_inscripcion){
        System.out.println("_____________________________________________________"+"\n");
        System.out.println("Eliminando inscripcion con id no."+id_inscripcion+" ...");
        System.out.println("_____________________________________________________"+"\n");
        int contador = 0;
        int eliminar = 0;
        int abono = 0;
        for (Map<String, Object> map_participantes : participantes) {
            for (Map.Entry<String, Object> inscripcion : map_participantes.entrySet()) {
                String clave = inscripcion.getKey();
                Object valor = inscripcion.getValue();
                if(valor.equals(id_inscripcion)){
                    eliminar = contador;
                }
            }
            contador ++;
        }
        Map<String, Object> map_participantes = participantes.get(eliminar);
        if(participantes == participantes_Circuito_avanzado){
            total_circuito_avanzado = total_circuito_avanzado - (Integer) map_participantes.get("abono");
            participantes.remove(eliminar);
            System.out.println(" Actualizacion inscritos a circuito avanzado: ");
            System.out.println(participantes_Circuito_avanzado);
        }

    }

}
