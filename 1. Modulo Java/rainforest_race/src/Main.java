import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Utils db = new Utils();

        boolean isMenuOpen = true;
        String menuTxt = "1) Inscribir participante.\n"+
                "2) Mostrar inscritos\n"+
                "3) Desinscribir un participante\n"+
                "4) Mostrar totales\n"+
                "5) Salir";

        do {
            System.out.println(menuTxt);
            System.out.println("Selecciona una opción:");
            int menuOption = userInput.nextInt();
            switch (menuOption) {
                case 1:
                    inscriptionMenu(db, userInput);
                    break;
                case 2:
                    showInscriptionsMenu(db, userInput);
                    break;
                case 3:
                    unsubscribeContestant(db, userInput);
                    break;
                case 4:
                    showTotalsMenu(db, userInput);
                    break;
                default:
                    isMenuOpen = false;
            }
        }while (isMenuOpen);

        System.out.println("Vuelve pronto.");
        userInput.close();
    }

    public static void inscriptionMenu(Utils db, Scanner userInput) {
        Map<Integer, Circuits> circuitsMap = db.getCircuitsList();

        // Menu to select the circuit
        System.out.println("A continuación enontrarás los circuitos disponibles:");
        for (Integer circuitId : circuitsMap.keySet()){
            System.out.println(circuitId + ") "+circuitsMap.get(circuitId).getName());
        }

        String inputIdMsg = "Ingresa el id del circuito que te interesa: ";
        String inputIdErrorMsg = "Ingresa un id válido: ";
        int selectedCircuitId;
        boolean isFirstInput = true;
        do {
            if (!isFirstInput)System.out.println(inputIdErrorMsg);else System.out.println(inputIdMsg);
            selectedCircuitId = userInput.nextInt();
            if (isFirstInput) isFirstInput = false;
        } while (!circuitsMap.containsKey(selectedCircuitId));

        // Check if the user already exists by its contestant number (contestantId)

        String contestantIdMsg = "Ingresa tu número de participante:";
        String contestantIdErrMsg = "Este número de participante ya se encuentra inscrito, ingresa uno diferente:";
        int contestantId;
        boolean contestantAlreadyExists = false;
        do{
            if (contestantAlreadyExists) System.out.println(contestantIdErrMsg); else System.out.println(contestantIdMsg);
            contestantId = userInput.nextInt();
            contestantAlreadyExists = db.contestantAlreadyExists(contestantId);
        } while (contestantAlreadyExists);

        // Get user data to create new contestant
        System.out.println("Ingresa tu DNI: ");
        long dni = userInput.nextLong();
        System.out.println("Ingresa tu nombre: ");
        String name = userInput.next();
        System.out.println("Ingresa tu apellido: ");
        String lastname = userInput.next();
        System.out.println("Ingresa tu edad: ");
        int age = userInput.nextInt();
        System.out.println("Ingresa tu número de celular: ");
        String cellphone = userInput.next();
        System.out.println("Ingresa un número de emergencia: ");
        String emerNumber = userInput.next();
        System.out.println("Ingresa tu tipo de sangre: ");
        char bloodType = userInput.next().charAt(0);

        Contestants newContestant = new Contestants(contestantId, dni, name, lastname, age, cellphone, emerNumber, bloodType);

        db.createContestant(newContestant);

        // Create the inscription for the new user
        Circuits selectedCircuit = circuitsMap.get(selectedCircuitId);
        Inscriptions newInscription = db.createInscription(newContestant, selectedCircuit);

        System.out.println("Se ha inscrito al participante ("+newContestant.getContestantId()+") "+newContestant.getName()+
                " al circuito \"("+selectedCircuit.getCircuitId()+") "+selectedCircuit.getName()+"\". Tu número de inscripción es "+
                newInscription.getInscriptionNumber());
    }

    public static void showInscriptionsByCategory(int categoryId, Utils db) {
        List<Inscriptions> filteredInscriptions = db.getInscriptionsByCategory(categoryId);
        String response = "Inscritos para "+db.getCircuitById(categoryId).getName();
        for (Inscriptions incription : filteredInscriptions) {
            Contestants contestant = db.getContestantById(incription.getContestantId());
            response += "\n+ "+incription.getInscriptionNumber()+") "+contestant.getUserStrData();
        }
        System.out.println(response);
    }

    public static void showInscriptionsMenu(Utils db, Scanner userInput) {
        String menuTxt = "";
        Map<Integer, Circuits> circuitsMap = db.getCircuitsList();
        for (Integer circuitId : circuitsMap.keySet()) {
            menuTxt += circuitId+") Inscritos a categoría "+circuitsMap.get(circuitId).getName()+"\n";
        }
        String inputIdMsg = menuTxt + "Selecciona el que te interese: ";
        String inputIdErrorMsg = menuTxt + "Ingresa un id válido: ";
        int selectedCircuitId;
        boolean isFirstInput = true;
        do {
            if (!isFirstInput)System.out.println(inputIdErrorMsg);else System.out.println(inputIdMsg);
            selectedCircuitId = userInput.nextInt();
            if (isFirstInput) isFirstInput = false;
        } while (!circuitsMap.containsKey(selectedCircuitId));

        showInscriptionsByCategory(selectedCircuitId, db);
    }

    public static void showTotalsMenu(Utils db, Scanner userInput) {
        String menuTxt = "0) Mostrar el total de todas las categorías\n";
        Map<Integer, Circuits> circuitsMap = db.getCircuitsList();
        for (Integer circuitId : circuitsMap.keySet()) {
            menuTxt += circuitId+") Total de categoría "+circuitsMap.get(circuitId).getName()+"\n";
        }

        String inputIdMsg = menuTxt + "Selecciona el que te interese: ";
        String inputIdErrorMsg = menuTxt + "Ingresa un id válido: ";
        int selectedCircuitId;
        boolean isFirstInput = true;
        do {
            if (!isFirstInput)System.out.println(inputIdErrorMsg);else System.out.println(inputIdMsg);
            selectedCircuitId = userInput.nextInt();
            if (isFirstInput) isFirstInput = false;
        } while (selectedCircuitId != 0 && !circuitsMap.containsKey(selectedCircuitId));

        // Show totals
        double totalAmount = db.getTotalsByCircuit(selectedCircuitId);
        System.out.println("El total es: "+totalAmount);
    }

    public static void unsubscribeContestant(Utils db, Scanner userInput){
        // Get contestantId
        String contestantIdMsg = "Ingresa el número de participante que quieres desinscribir:";
        String contestantIdErrMsg = "Este número de participante no existe, ingresa uno diferente:";
        int contestantId;
        boolean contestantAlreadyExists = true;
        do{
            if (!contestantAlreadyExists) System.out.println(contestantIdErrMsg); else System.out.println(contestantIdMsg);
            contestantId = userInput.nextInt();
            contestantAlreadyExists = db.contestantAlreadyExists(contestantId);
        } while (!contestantAlreadyExists);
        // Get Inscription by contestantId
        Inscriptions selectedInscription = db.getInscriptionByContestantId(contestantId);
        if (selectedInscription == null) {
            System.out.println("Ese usuario no se encuentra inscrito a ningún circuito aún.");
            return;
        }
        // Get the categoryId using the Inscription
        int circuitId = selectedInscription.getCategoryId();
        // Delete the inscription from the inscriptionsList
        db.deleteInscription(selectedInscription);
        // Show the inscriptions by the categoryId
        showInscriptionsByCategory(circuitId, db);
    }
}