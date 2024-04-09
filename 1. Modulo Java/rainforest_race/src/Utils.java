import java.util.*;
import java.util.stream.Collectors;

public class Utils {
    private List<Circuits> circuitsList;
    private List<Contestants> contestantsList;
    private List<Inscriptions> inscriptionsList;

    public Utils() {
        // # Create and add the default circuits
        this.circuitsList = getCircuits();

        // # Create and add contestants
        this.contestantsList = getContestants();

        // # Create and add the inscriptions
        List<Inscriptions> inscriptions = new ArrayList<>();
        int circuitsSize = this.circuitsList.size();
        for (int i = 0; i < contestantsList.size(); i++) {
            int circuitInd = i % circuitsSize;
            Circuits selectedCircuit = circuitsList.get(circuitInd);
            double inscriptionPrice = selectedCircuit.getKidPrice();
            Contestants contestant = contestantsList.get(i);
            if (contestant.getAge() >= 18) inscriptionPrice = selectedCircuit.getAdultPrice();
            inscriptions.add(new Inscriptions(i, selectedCircuit.getCircuitId(), contestant.getContestantId(), inscriptionPrice));
        }
        this.inscriptionsList = inscriptions;
    }

    private static List<Circuits> getCircuits() {
        List<Circuits> circuits = new ArrayList<>();
        circuits.add(new Circuits(1,"Circuito chico", 2, "Selva y arroyos", false, 1300, 1500));
        circuits.add(new Circuits(2,"Circuito medio", 5, "Selva, arroyos y barro", false, 2000, 2300));
        circuits.add(new Circuits(3,"Circuito avanzado", 10, "Selva, arroyos, barro y escalada en piedra", true, 2800));
        return circuits;
    }

    private static List<Contestants> getContestants() {
        List<Contestants> contestants = new ArrayList<>();
        contestants.add(new Contestants(1, 10000001, "Armando", "Casas", 21, "3110000001", "3120000001", 'A'));
        contestants.add(new Contestants(2, 10000002, "Juan", "Carlo", 16, "3110000002", "3120000002", 'O'));
        contestants.add(new Contestants(3, 10000003, "Camilo", "Sanchez", 18, "3110000003", "3120000003", 'B'));
        contestants.add(new Contestants(4, 10000004, "Andres", "Perez", 26, "3110000004", "3120000004", 'A'));
        contestants.add(new Contestants(5, 10000005, "Maria", "Valbuena", 43, "3110000005", "3120000005", 'O'));
        contestants.add(new Contestants(6, 10000006, "Susana", "Magna", 73, "3110000006", "3120000006", 'A'));
        contestants.add(new Contestants(7, 10000007, "Luna", "Loaiza", 13, "3110000007", "3120000007", 'B'));
        contestants.add(new Contestants(8, 10000008, "Eva", "Castillo", 15, "3110000008", "3120000008", 'B'));

        return contestants;
    }

    public Map<Integer, Circuits> getCircuitsList() {
        Map<Integer, Circuits> circuitsMap = new HashMap<>();

        for (Circuits currCircuit : this.circuitsList) {
            circuitsMap.put(currCircuit.getCircuitId(), currCircuit);
        }

        return circuitsMap;
    }

    public List<Contestants> getContestantsList() {
        return this.contestantsList;
    }
    public List<Inscriptions> getInscriptionsList() {
        return this.inscriptionsList;
    }
    public List<Circuits> getAllCircuits() {
        return this.circuitsList;
    }

    public Circuits getCircuitById(int circuitId) {
        return this.circuitsList.stream()
                .filter(circuit -> circuit.getCircuitId() == circuitId)
                .findAny()
                .orElse(null);
    }

    public List<Inscriptions> getInscriptionsByCategory(int categoryId) {
        return this.inscriptionsList.stream()
                .filter(inscription -> inscription.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

    public Inscriptions getInscriptionByContestantId(int contestantId) {
        return this.inscriptionsList.stream()
                .filter(inscription -> inscription.getContestantId() == contestantId)
                .findAny()
                .orElse(null);
    }

    public void createContestant(Contestants newContestant) {
        this.contestantsList.add(newContestant);
    }

    public boolean contestantAlreadyExists(int contestantId) {
        Contestants foundContestant = getContestantById(contestantId);

        return foundContestant != null;
    }

    public Contestants getContestantById(int contestantId) {
        return this.contestantsList.stream()
                .filter(contestant -> contestant.getContestantId() == contestantId)
                .findAny()
                .orElse(null);
    }

    public Inscriptions createInscription(Contestants contestant, Circuits circuit) {
        int inscriptionsQuantity = this.inscriptionsList.size();
        if (circuit.isAdultsOnly() && contestant.getAge() < 18) {
            System.out.println("En este circuito no se aceptan menores de edad");
            return null;
        }
        double circuitCost;
        if (contestant.getAge() >= 18) {
            circuitCost = circuit.getAdultPrice();
        } else {
            circuitCost = circuit.getKidPrice();
        }

        Inscriptions newInscription = new Inscriptions(inscriptionsQuantity, circuit.getCircuitId(), contestant.getContestantId(), circuitCost);
        this.inscriptionsList.add(newInscription);
        return newInscription;
    }

    public void deleteInscription(Inscriptions inscription) {
        this.inscriptionsList.remove(inscription);
    }

    public double getTotalsByCircuit(int circuitId) {
        double total = 0;
        List<Inscriptions> inscriptions = this.inscriptionsList;
        if (circuitId != 0) {
            inscriptions = this.getInscriptionsByCategory(circuitId);
        }
        for (Inscriptions inscription : inscriptions) {
            total += inscription.getInscriptionAmount();
        }

        return total;
    }
}
