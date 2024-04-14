package com.company;

import java.util.*;

public class CarreraDeLaSelva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Declaramos las estructuras que vamos a necesitar
        List<String> tiposCircuitos = new ArrayList<String>(); //Circuitos
        Map<Integer,Integer[]> registros = new HashMap<Integer, Integer[]>(); //Seguimiento de los registros
        Map<Integer,String[]> participantes = new HashMap<Integer,String[]>(); //Participantes
        boolean loop=true;
        int numeroRegistrosIngresados = 0; //No necesariamente representa la cantidad de registros, actuales, solo los que Historicamente se han dado de alta

        //Cargamos datos.

        //Tipos de circuitos
        tiposCircuitos.add("Circuito chico: 2 km por selva y arroyos.");
        tiposCircuitos.add("Circuito medio: 5 km por selva, arroyos y barro.");
        tiposCircuitos.add("Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");


        //Valores: DNI, Nombre, Apellido,Edad,Celular,Numero de emergencia,Grupo Sanguineo y Espacio para Categoría;
        String[] participante1 = {"Juan", "Perez", "25", "999888777", "911", "A+",};
        participantes.put(1,participante1);
        String[] participante2 = {"Juan2", "Perezz", "25", "999888777", "911", "B+"};
        participantes.put(2,participante2);
        String[] participante3 = {"Luz", "Martinez", "25", "999888777", "911", "A+"};
        participantes.put(3,participante3);
        while(loop){
            System.out.println("Opciones: 1.Alta de Usuarios 2. Baja de usuarios 3. Alta de Registro 4. Baja de Registro 5. Verificar Inscritos 6.Calcular Recaudacion 7.Verificar usuarios"  );
            int auxiliar;
            String[] datosParticipante;
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    //Alta de Usuarios
                    //Valores: DNI, Nombre, Apellido,Edad,Celular,Numero de emergencia,Grupo Sanguineo;
                    System.out.println("Ingrese DNI");
                    int dniPrimitivo = scanner.nextInt(); // Lee un entero
                    Integer dni = dniPrimitivo; //Cast a Integer para que sea Key
                    System.out.println("Ingrese nombre(s)");
                    String nombre = scanner.next();
                    System.out.println("Ingrese apellido");
                    String apellido = scanner.next();
                    System.out.println("Ingrese edad");
                    String edad = scanner.next();
                    //Validacion de edad porque se necesita a futuro
                    try {
                        int numeroComoInt = Integer.parseInt(edad);
                    } catch (NumberFormatException e) {
                        System.out.println("No se ingreso una edad valida");
                        break;
                    }
                    System.out.println("Ingrese celular");
                    String celular = scanner.next();
                    System.out.println("Ingrese Numero de Emergencia");
                    String numeroEmergencia = scanner.next();
                    System.out.println("Ingrese Grupo Sanguineo");
                    String tipoSangre = scanner.next();
                    //Por términos de ejemplo, no se hará validaciones de datos como DNI, tamaño, telefono como numerico,etc
                    // Tampoco se tomará DNI como ID (Aunque en otro caso, sería lo mejor).
                    String[] nuevoParticipante = {nombre,apellido,edad,celular,numeroEmergencia,tipoSangre};
                    participantes.put(dni,nuevoParticipante);
                    System.out.println("Usuario "+ nombre+ " "+ apellido+" Registrado.");
                    break;
                case 2:
                    //Baja de Usuarios
                    System.out.println("Ingrese DNI");
                    auxiliar = scanner.nextInt();
                    datosParticipante= participantes.get(auxiliar);
                    System.out.println("Nombre: "+datosParticipante[1]+ " - Apellido: "+datosParticipante[2]+ " - DNI: "+ datosParticipante[0]);
                    System.out.println("¿Confirma que sus datos son correctos? y/n");
                    String confirmacion = scanner.next();
                    if(confirmacion.equals("y")){
                        participantes.remove(auxiliar);
                    }
                    break;
                case 3:
                    //Alta de Registro
                    System.out.println("Ingrese DNI");
                    auxiliar  = scanner.nextInt();
                    if(participantes.containsKey(auxiliar)){
                        datosParticipante= participantes.get(auxiliar);
                        System.out.println("Ingrese el tipo de carrera que desea");
                        int numCarrera= scanner.nextInt();
                        int edadParticipante = Integer.parseInt(datosParticipante[2]); //Casteamos para verificar costos
                        //Datos: ID,{DNI,TIPO_CARRERA,Monto}
                        switch (numCarrera){
                            case 1:
                                if(edadParticipante<18){
                                    Integer[] datosCarrera = {auxiliar,1,1300};
                                    numeroRegistrosIngresados++;
                                    registros.put(numeroRegistrosIngresados,datosCarrera);
                                    System.out.println("Registro Exitoso. Numero de registro: "+numeroRegistrosIngresados);
                                }
                                else {
                                    Integer[] datosCarrera = {auxiliar,1,1500};
                                    numeroRegistrosIngresados++;
                                    registros.put(numeroRegistrosIngresados,datosCarrera);
                                    System.out.println("Registro Exitoso. Numero de registro: "+numeroRegistrosIngresados);
                                }
                                break;
                            case 2:
                                if(edadParticipante<18){
                                    Integer[] datosCarrera = {auxiliar,2,2000};
                                    numeroRegistrosIngresados++;
                                    registros.put(numeroRegistrosIngresados,datosCarrera);
                                    System.out.println("Registro Exitoso. Numero de registro: "+numeroRegistrosIngresados);
                                }
                                else {
                                    Integer[] datosCarrera = {auxiliar,2,2300};
                                    numeroRegistrosIngresados++;
                                    registros.put(numeroRegistrosIngresados,datosCarrera);
                                    System.out.println("Registro Exitoso. Numero de registro: "+numeroRegistrosIngresados);
                                }
                                break;
                            case 3:
                                if(edadParticipante<18){
                                    System.out.println("Esta carrera solo es para adultos");
                                }
                                else {
                                    Integer[] datosCarrera = {auxiliar,3,2800};
                                    numeroRegistrosIngresados++;
                                    registros.put(numeroRegistrosIngresados,datosCarrera);
                                    System.out.println("Registro Exitoso. Numero de registro: "+numeroRegistrosIngresados);
                                }
                                break;
                            default:
                                System.out.println("Verifique la cantidad de carreras");
                                break;
                        }
                    }
                    else {
                        System.out.println("No encontramos al usuario ¿Desea que lo registremos?");
                    }
                    break;
                case 4:
                    //Baja de Registro
                    System.out.println("Ingrese el numero de registro  a dar de baja.");
                    auxiliar = scanner.nextInt();
                    if(registros.containsKey(auxiliar)){
                        registros.remove(auxiliar);
                        System.out.println("Se elimino su registro(No le devolveremos su dinero)");
                    }
                    else{
                        System.out.println("O alguien fue más rápido o necesita verificar su numero de registro");
                    }
                    break;
                case 5:
                    //Verificar inscritos por categoria
                    // Mostrar registros totales
                    System.out.println("Registros totales:");
                    for (Integer clave : registros.keySet()) {
                        Integer[] valores = registros.get(clave);
                        System.out.println("Registro " + clave + ": " + Arrays.toString(valores));
                    }
                    // Mostrar registros por categoría
                    // Creamos un mapa para almacenar la cantidad de registros por cada categoría
                    Map<Integer, Integer> registrosPorCategoria = new HashMap<Integer, Integer>();
                    for (Integer clave : registros.keySet()) {
                        Integer[] valores = registros.get(clave);
                        Integer categoria = valores[1];

                        // Si la categoría ya existe en el mapa, incrementamos su contador
                        if (registrosPorCategoria.containsKey(categoria)) {
                            registrosPorCategoria.put(categoria, registrosPorCategoria.get(categoria) + 1);
                        } else {
                            // Si la categoría no existe, agregamos una nueva entrada con un contador inicializado en 1
                            registrosPorCategoria.put(categoria, 1);
                        }
                    }

                    // Iteramos sobre el mapa de registros por categoría y mostramos los resultados
                    for (Integer categoria : registrosPorCategoria.keySet()) {
                        System.out.println("Categoría " + categoria + ": " + registrosPorCategoria.get(categoria) + " registros");
                    }
                    break;
                case 6:
                    //Calculo de recaudacion
                    // Mostrar registros por categoría y sumar los datos en la posición [2] (Monto cobrado)
                    System.out.println("Registros por categoría y suma de ingresos:");

                    // Creamos un mapa para almacenar la suma de los datos en la posición [2] por cada categoría
                    Map<Integer, Integer> sumaPorCategoria = new HashMap<Integer, Integer>();
                    // Variable para almacenar la suma total de todos los datos en la posición [2]
                    int sumaTotal = 0;

                    for (Integer clave : registros.keySet()) {
                        Integer[] valores = registros.get(clave);
                        Integer categoria = valores[1];
                        Integer datoPosicion2 = valores[2];

                        // Si la categoría ya existe en el mapa, sumamos el dato en la posición [2]
                        if (sumaPorCategoria.containsKey(categoria)) {
                            sumaPorCategoria.put(categoria, sumaPorCategoria.get(categoria) + datoPosicion2);
                        } else {
                            // Si la categoría no existe, agregamos una nueva entrada con el valor inicializado en el dato de la posición [2]
                            sumaPorCategoria.put(categoria, datoPosicion2);
                        }

                        // Sumamos el dato en la posición [2] para obtener la suma total
                        sumaTotal += datoPosicion2;
                    }

                    // Iteramos sobre el mapa de suma por categoría y mostramos los resultados
                    for (Integer categoria : sumaPorCategoria.keySet()) {
                        System.out.println("Categoría " + categoria + ": Aculumado: " + sumaPorCategoria.get(categoria));
                    }

                    // Mostramos la suma total de todos los ingresos
                    System.out.println("Suma total de todos los ingresos: " + sumaTotal);
                    break;
                case 7:
                    //Extraemos los datos de todos los participantes
                    for(Map.Entry<Integer,String[]> entrada : participantes.entrySet()){
                        int idParticipante = entrada.getKey();
                        datosParticipante = entrada.getValue();
                        System.out.println("-------------------");
                        System.out.println("  ID del participante:" + idParticipante);
                        System.out.print("Datos del participante:");
                        String datos = "";
                        for (String dato : datosParticipante) {
                            datos += dato+" // ";
                        }
                        System.out.println(datos);
                    }
                    break;
                default:
                    loop = false;
                    System.out.println("Gracias por utilizar el sistema!");
                    break;
            }
        }

    }
}