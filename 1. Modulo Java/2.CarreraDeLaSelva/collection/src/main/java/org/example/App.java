package org.example;

import java.util.*;

public class App {
    public static void main(String[] args) {
        int amountShortCategory = 0;
        int amountMidCategory = 0;
        int amountLongCategory = 0;
        int totalAmount = 0;
        Map <String, Map> inscriptionList = new HashMap<>();
        Map <Integer, List> categories = new HashMap<>();
        List <String> smallCircuit = new ArrayList<>();
        List <String> midCircuit = new ArrayList<>();
        List <String> longCircuit = new ArrayList<>();

        smallCircuit.add("Circuito chico");
        smallCircuit.add("2km por selva y arroyos");

        midCircuit.add("Circuito medio");
        midCircuit.add("5 km por selva, arroyos y barro");

        longCircuit.add("Circuito avanzado");
        longCircuit.add("10 km por selva, arroyos, barro y escalada en piedra");

        categories.put(1, smallCircuit);
        categories.put(2, midCircuit);
        categories.put(3, longCircuit);

        List<Map> participanList = new ArrayList<>();

        Map<String, String> participant1 = new HashMap<>();
        Map<String, String> participant2 = new HashMap<>();
        Map<String, String> participant3 = new HashMap<>();


        participant1.put("NumParticipant", "1");
        participant1.put("dni", "00007");
        participant1.put("name", "Luis");
        participant1.put("lastName", "Meza");
        participant1.put("age", "24");
        participant1.put("phone", "1898797");
        participant1.put("phoneEmergency", "155345");
        participant1.put("blodeType", "A");
        participant1.put("category", (String) categories.get(1).get(0));

        participant2.put("NumParticipant", "2");
        participant2.put("dni", "00017");
        participant2.put("name", "Fernanda");
        participant2.put("lastName", "Arguello");
        participant2.put("age", "17");
        participant2.put("phone", "1898797");
        participant2.put("phoneEmergency", "155345");
        participant2.put("blodeType", "A");
        participant2.put("category", (String) categories.get(1).get(0));

        participant3.put("NumParticipant", "3");
        participant3.put("dni", "00027");
        participant3.put("name", "David");
        participant3.put("lastName", "Gora");
        participant3.put("age", "29");
        participant3.put("phone", "1898797");
        participant3.put("phoneEmergency", "155345");
        participant3.put("blodeType", "A");
        participant3.put("category", (String) categories.get(2).get(0));

        participanList.add(participant1);
        participanList.add(participant2);
        participanList.add(participant3);

        for (int i = 0; i < participanList.size(); i++) {
            String ageOfParticipant = (String) participanList.get(i).get("age");
            String categoryType = (String) participanList.get(i).get("category");
            Map<String, String> inscription = new HashMap<>();
            if (Integer.parseInt(ageOfParticipant) < 18){

                if (categoryType == "Circuito chico") {

                    inscription.put("category",(String) participanList.get(i).get("category"));
                    inscription.put("participant" , participanList.get(i).toString());
                    inscription.put("mount", "1300");
                } else if (categoryType == "Circuito medio"){
                    inscription.put("numInscription" , "1");
                    inscription.put("category",(String) participanList.get(i).get("category"));
                    inscription.put("participant" , participanList.get(i).toString());
                    inscription.put("mount", "2000");
                }

            } else {
                if (categoryType == "Circuito chico") {
                    inscription.put("category",(String) participanList.get(i).get("category"));
                    inscription.put("participant" , participanList.get(i).toString());
                    inscription.put("mount", "1500");
                } else if (categoryType == "Circuito medio"){
                    inscription.put("category",(String) participanList.get(i).get("category"));
                    inscription.put("participant" , participanList.get(i).toString());
                    inscription.put("mount", "2300");
                } else {
                    inscription.put("category",(String) participanList.get(i).get("category"));
                    inscription.put("participant" , participanList.get(i).toString());
                    inscription.put("mount", "2800");
                }
            }

            inscriptionList.put("a10" + i, inscription);


        }

        System.out.println("Que desea hacer? 1) mostrar lista de inscripcion \n2) Desincribir a alguien\n 3) Calcular monto total de cada categoria \n 4) Monto total de la carrera");

        Scanner myScanner = new Scanner(System.in);
        int option = myScanner.nextInt();

        switch (option){
            case 1:
                System.out.println(inscriptionList);
                break;
            case 2:
                System.out.println("ingrese el numero de inscripcion a eliminar");
                Scanner scanner = new Scanner(System.in);
                String numInscription = scanner.nextLine();
                inscriptionList.remove(numInscription);
                System.out.println(inscriptionList);
                break;
            case 3:

                for (String key : inscriptionList.keySet()) {
                    Map value = inscriptionList.get(key);

                    if (value.get("category") == "Circuito chico") {
                        String amount = (String) value.get("mount");
                        amountShortCategory += Integer.parseInt(amount);

                    }

                    if (value.get("category") == "Circuito medio") {
                        String amount = (String) value.get("mount");
                        amountMidCategory += Integer.parseInt(amount);

                    }
                    
                    if (value.get("category") == "Circuito avanzado") {
                        String amount = (String) value.get("mount");
                        amountLongCategory += Integer.parseInt(amount);

                    }

                }

                System.out.println("Categoria chico " + amountShortCategory);
                System.out.println("Categoria medio " + amountMidCategory);
                System.out.println("Categoria avanzado " + amountLongCategory);
                break;
            case 4:
                for (String key : inscriptionList.keySet()) {
                    Map value = inscriptionList.get(key);
                    String amount = (String) value.get("mount");
                    totalAmount += Integer.parseInt(amount);

                }

                System.out.println("Total amount : " + totalAmount);
                break;

            default:
                System.out.println("Incorrect input");
        }


    }
}
