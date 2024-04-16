package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List <Circuits> circuits = new ArrayList<>();
        List <Competitors> competitors = new ArrayList<>();
        List <Inscriptions> inscriptions = new ArrayList<>();
        
        circuits.add(new Circuits(1, "Circuito pequeño", 2, "Selva y arroyos", 1300, 1500));
        circuits.add(new Circuits(2, "Circuito mediano", 5, "Selva, arroyos y barro", 2000, 2300));
        circuits.add(new Circuits(3, "Circuito avanzado", 10, "Selva, arroyos, barro y escalada en piedra", 2800, true));

        competitors.add(new Competitors(1, "12345678A", "Juan", "Pérez", 25, "666555444", "666333222", "A+"));

        inscriptions.add(new Inscriptions(1, 1, 1, 1500));
    
        competitors.add(new Competitors(2, "87654321B", "María", "Gómez", 15, "666555444", "666333222", "B+"));
        competitors.add(new Competitors(3, "12345678C", "Pedro", "Martínez", 20, "666555444", "666333222", "AB+"));
        competitors.add(new Competitors(4, "87654321D", "Ana", "García", 30, "666555444", "666333222", "O+"));
        competitors.add(new Competitors(5, "12345678E", "Luis", "Fernández", 40, "666555444", "666333222", "A-"));
        competitors.add(new Competitors(6, "87654321F", "Carmen", "López", 50, "666555444", "666333222", "B-"));
        competitors.add(new Competitors(7, "12345678G", "Antonio", "Sánchez", 60, "666555444", "666333222", "AB-"));
        competitors.add(new Competitors(8, "87654321H", "Rosa", "Romero", 70, "666555444", "666333222", "O-"));

        inscriptions.add(new Inscriptions(2, 2, 2, 2000));
        inscriptions.add(new Inscriptions(3, 3, 3, 2800));
        inscriptions.add(new Inscriptions(4, 1, 4, 1500));
        inscriptions.add(new Inscriptions(5, 2, 5, 2000));
        inscriptions.add(new Inscriptions(6, 3, 6, 2800));
        inscriptions.add(new Inscriptions(7, 1, 7, 1500));
        inscriptions.add(new Inscriptions(8, 2, 8, 2000));

        // Mostrar los competidores al circuito 1
        System.out.println("Competitors in circuit 1:");
        showCompetitorsInCircuit(competitors, inscriptions, 1);

        // Desinscribir a un competidor
        for (int i = 0; i < inscriptions.size(); i++) {
            if (inscriptions.get(i).getIdCompetitor() == 1) {
                inscriptions.remove(i);
            }
        }

        // Mostrar los competidores al circuito 1
        System.out.println("Competitors in circuit 1:");
        showCompetitorsInCircuit(competitors, inscriptions, 1);

        // Calcular el precio acumulado de cada circuito
        HashMap<Integer, Double> prices = new HashMap<>();
        for (Circuits circuit : circuits) {
            double price = 0;
            for (Inscriptions inscription : inscriptions) {
                if (inscription.getCategory() == circuit.getIdCircuit()) {
                    price += inscription.getPrice();
                }
            }
            prices.put(circuit.getIdCircuit(), price);
        }

        System.out.println("Prices of circuits:");
        for (Circuits circuit : circuits) {
            System.out.println("Circuit: " + circuit.getIdCircuit() + " - " + circuit.getName() + " - " + prices.get(circuit.getIdCircuit()));
        }

        // Mostrar el total de recaudación
        double total = 0;
        for (Double price : prices.values()) {
            total += price;
        }

        System.out.println("Total: " + total);
    }

    public static void showCompetitorsInCircuit(List<Competitors> competitors, List<Inscriptions> inscriptions, int category) {
        for (Inscriptions inscription : inscriptions) {
            if (inscription.getCategory() == category) {
                for (Competitors competitor : competitors) {
                    if (inscription.getIdCompetitor() == competitor.getIdCompetitor()) {
                        System.out.println("Inscription: " + inscription.getIdInscription() + " - " + competitor);
                    }
                }
            }
        }
    }
}
