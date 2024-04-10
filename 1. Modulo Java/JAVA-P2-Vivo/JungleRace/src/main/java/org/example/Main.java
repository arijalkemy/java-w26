package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Categories
        Category[] categories = new Category[]{
            new Category(0, "Circuito Corto", "2 km por selva y arroyos."),
            new Category(1, "Circuito Medio", "5 km por selva, arroyos y barro."),
            new Category(2, "Circuito Largo", "10 km por selva, arroyos, barro y escalada en piedra.")
        };

        // Participants
        Participant[] participants = new Participant[]{
                new Participant(0, "dni_1", "Luis", "Jimenez", 18, "2233445533", "3355667788", "B+"),
                new Participant(1, "dni_2", "Carlos", "Jimenez", 29, "2233445533", "3355667788", "B+"),
                new Participant(2, "dni_3", "Nacho", "Jimenez", 38, "2233445533", "3355667788", "B+"),
                new Participant(3, "dni_4", "Karla", "Jimenez", 17, "2233445533", "3355667788", "B+"),
                new Participant(4, "dni_5", "Jose", "Jimenez", 19, "2233445533", "3355667788", "B+"),
                new Participant(5, "dni_6", "Julia", "Jimenez", 16, "2233445533", "3355667788", "B+"),
        };

        List<Inscription> inscriptions = new ArrayList<Inscription>();
        // Inscriptions NORMAL
        for(int i = 0; i < participants.length; i++){
            // CONSECUTIVE CATEGORIES
            if(i < participants.length / 2){
                inscriptions.add(new Inscription(
                        i,
                        categories[i],
                        participants[i]
                ));
            }else{
                // RANDOM CATEGORIES
                int categoryId = (int) (Math.random() * 3);
                inscriptions.add(new Inscription(
                        i,
                        categories[categoryId],
                        participants[i]
                ));
            }

        }

        // Prints inscriptions
        System.out.println("-----------------------------------");
        System.out.println("INSCRIPTIONS RESULT");
        for(Inscription inscription: inscriptions){
            String res = String.format("Participant: %s - Age: %d - Category: %s - Amount to Pay: %s - Status: %s",
                    inscription.getParticipant().getName(),
                    inscription.getParticipant().getAge(),
                    inscription.getCategory().getName(),
                    (inscription.getAmountPayable() == 0) ? "N/A" : "" + inscription.getAmountPayable(),
                    (inscription.getStatus()) ? "Activo" : "No activo"
            );
            System.out.println(res);
        }

        // Unscribe one participant
        System.out.println("-----------------------------------");
        System.out.println("NEW LIST");
        int randomUnsubscription = (int) (Math.random() * participants.length);
        String unsubscripbe = String.format("Unsubscribing: Participant: %s - Category: %s",
                inscriptions.get(randomUnsubscription).getParticipant().getName(),
                inscriptions.get(randomUnsubscription).getCategory().getName()
        );
        System.out.println(unsubscripbe);
        inscriptions.remove(randomUnsubscription);
        for(Inscription inscription: inscriptions){
            String res = String.format("Participant: %s - Age: %d - Category: %s - Amount to Pay: %s - Status: %s",
                    inscription.getParticipant().getName(),
                    inscription.getParticipant().getAge(),
                    inscription.getCategory().getName(),
                    (inscription.getAmountPayable() == 0) ? "N/A" : "" + inscription.getAmountPayable(),
                    (inscription.getStatus()) ? "Activo" : "No activo"
            );
            System.out.println(res);
        }


        System.out.println("-----------------------------------");
        Map<Integer, Double> amountPerCategory = new HashMap<Integer, Double>();
        for(Inscription inscription: inscriptions){
            int key = inscription.getCategory().getId();
            if(amountPerCategory.containsKey(key)){
                Double acc = amountPerCategory.get(key) + inscription.getAmountPayable();
                amountPerCategory.put(key, acc);
            }else{
                amountPerCategory.put(key, inscription.getAmountPayable());
            }
        }

        System.out.println("GETTING GENERAL AMOUNTS");
        for(Map.Entry<Integer, Double> category: amountPerCategory.entrySet()){
            String res = String.format("Category: %s - Amount: %s", categories[category.getKey()].getName(), ""+category.getValue());
            System.out.println(res);
        }
    }
}