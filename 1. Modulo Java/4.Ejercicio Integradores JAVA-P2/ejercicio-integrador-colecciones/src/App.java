import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Category circuitOne = new Category("1", "chico", "2 km por selva y arroyos");
        Category circuitTwo = new Category("2", "medio", "5 km por selva, arroyos y barro");
        Category circuitThree = new Category("3", "avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        HashMap<Player, Inscription> inscription = new HashMap<>();
        List<Player> players = new LinkedList<Player>();

        Scanner scn = new Scanner(System.in);
        boolean op = true;
        int menuOption = 0;

        String idCategory = "";
        String idPlayer = "";
        int idInscription = 0;
        double totalCategory = 0;

        while (op) {
            System.out.println();
            System.out.println("Bienvenido al mini sistema de inscripciones!" + "\n" +
                    "Elige una opción: " + "\n" +
                    "1. Crear Participante" + "\n" +
                    "2. Inscribir Participante" + "\n" +
                    "3. Mostrar Participantes" + "\n" +
                    "4. Desincribir participante" + "\n" +
                    "5. Calcular monto recaudado" + "\n" +
                    "6. Salir");
            System.out.print(">_ ");
            menuOption = scn.nextInt();
            scn.nextLine();

            switch (menuOption) {
                case 1:
                    Player player = new Player();
                    System.out.println("Digite los datos del participante");

                    System.out.print("ID: ");
                    player.setId(scn.next());
                    scn.nextLine();

                    System.out.print("DNI: ");
                    player.setDni(scn.next());
                    scn.nextLine();

                    System.out.print("Nombre: ");
                    player.setName(scn.next());
                    scn.nextLine();

                    System.out.print("Apellido: ");
                    player.setLastName(scn.next());
                    scn.nextLine();

                    System.out.print("Edad: ");
                    player.setAge(scn.nextInt());
                    scn.nextLine();

                    System.out.print("Celular: ");
                    player.setCellphone(scn.next());
                    scn.nextLine();

                    System.out.print("Celular 2: ");
                    player.setAuxCellphone(scn.next());
                    scn.nextLine();

                    System.out.print("RH: ");
                    player.setBloodType(scn.next());
                    scn.nextLine();

                    System.out.println();
                    players.add(player);
                    System.out.println("Usuario agregado!");

                    System.out.println("Usuarios actuales:");
                    for (Player item : players) {
                        System.out.print("\n" +
                                "-----------------------------------" + "\n" +
                                "ID: " + item.getId() + "\n" +
                                "Nombre: " + item.getName() + "\n" +
                                "Apellido: " + item.getLastName() + "\n" +
                                "DNI: " + item.getDni() + "\n" +
                                "Edad: " + item.getAge() + "\n" +
                                "Celular: " + item.getCellphone() + "\n" +
                                "Celular 2: " + item.getAuxCellphone() + "\n" +
                                "RH: " + item.getBloodType() + "\n" +
                                "------------------------------------");
                    }
                    break;

                case 2:
                    Inscription newInscription = new Inscription();
                    System.out.println("¿A cuál participante desea inscribir?");
                    for (Player item : players) {
                        System.out.print("\n" +
                                "-----------------------------------" + "\n" +
                                "ID: " + item.getId() + "\n" +
                                "Nombre: " + item.getName() + "\n" +
                                "Apellido: " + item.getLastName() + "\n" +
                                "DNI: " + item.getDni() + "\n" +
                                "Edad: " + item.getAge() + "\n" +
                                "Celular: " + item.getCellphone() + "\n" +
                                "Celular 2: " + item.getAuxCellphone() + "\n" +
                                "RH: " + item.getBloodType() + "\n" +
                                "------------------------------------");
                    }

                    idPlayer = scn.next();
                    scn.nextLine();

                    System.out.println("¿A qué categoría desea inscribirlo?: " + "\n" +
                            "1. Circuito chico" + "\n" +
                            "2. Circuito mediano" + "\n" +
                            "3. Circuito grande" + "\n");
                    idCategory = scn.next();

                    int playerIndex = Integer.parseInt(idPlayer) - 1;

                    if (playerIndex >= 0 && playerIndex < players.size()) {
                        if (idCategory.equals("1")) {
                            newInscription.setId(String.valueOf(++idInscription));
                            newInscription.setCategory(circuitOne);
                            newInscription.setAmount(newInscription.calculateAmount(
                                    players.get(playerIndex).getAge(), idCategory));
                            inscription.put(players.get(playerIndex), newInscription);

                        } else if (idCategory.equals("2")) {
                            newInscription.setId(String.valueOf(++idInscription));
                            newInscription.setCategory(circuitTwo);
                            newInscription.setAmount(newInscription.calculateAmount(
                                    players.get(playerIndex).getAge(), idCategory));
                            inscription.put(players.get(playerIndex), newInscription);

                        } else if (idCategory.equals("3")) {
                            newInscription.setId(String.valueOf(++idInscription));
                            newInscription.setCategory(circuitThree);
                            newInscription.setAmount(newInscription.calculateAmount(
                                    players.get(playerIndex).getAge(), idCategory));
                            inscription.put(players.get(playerIndex), newInscription);
                        } else {
                            System.out.println("Opción errónea");
                        }
                    } else {
                        System.out.println("ID de participante incorrecto");
                    }
                    break;

                case 3:
                    System.out.println("¿De qué categoría quieres ver los inscritos?: " + "\n" +
                            "1. Circuito chico" + "\n" +
                            "2. Circuito mediano" + "\n" +
                            "3, Circuito grande" + "\n");
                    idCategory = scn.next();

                    if (idCategory.equals("1") || idCategory.equals("2") || idCategory.equals("3")) {
                        for (HashMap.Entry<Player, Inscription> entry : inscription.entrySet()) {
                            Player tempPlayer = entry.getKey();
                            Inscription tempInscription = entry.getValue();

                            if ((tempInscription.getCategory().getId()).equals(idCategory)) {
                                System.out.println("----------------------------" + "\n" +
                                        "Nombre: " + tempPlayer.getName() + "\n" +
                                        "Apellido: " + tempPlayer.getLastName() + "\n" +
                                        "DNI: " + tempPlayer.getDni() + "\n" +
                                        "Age: " + tempPlayer.getAge() + "\n" +
                                        "Categoría: " + tempInscription.getCategory().getName() + "\n" +
                                        "Descripción: " + tempInscription.getCategory().getDescription() + "\n" +
                                        "Valor: " + tempInscription.getAmount());
                            }
                        }
                    } else {
                        System.out.println("Opción errónea");
                    }
                    break;
                case 4:
                    System.out.println("¿A cual participante desea desinscribir? Digita su ID");
                    for (HashMap.Entry<Player, Inscription> entry : inscription.entrySet()) {
                        Player tempPlayer = entry.getKey();
                        Inscription tempInscription = entry.getValue();

                        System.out.println("----------------------------" + "\n" +
                                "ID:" + tempPlayer.getId() + "\n" +
                                "Nombre: " + tempPlayer.getName() + "\n" +
                                "Apellido: " + tempPlayer.getLastName() + "\n" +
                                "DNI: " + tempPlayer.getDni() + "\n" +
                                "Age: " + tempPlayer.getAge() + "\n" +
                                "Categoría: " + tempInscription.getCategory().getName() + "\n" +
                                "Descripción: " + tempInscription.getCategory().getDescription() + "\n" +
                                "Valor: " + tempInscription.getAmount());

                    }

                    idPlayer = scn.next();
                    scn.nextLine();

                    for (HashMap.Entry<Player, Inscription> entry : inscription.entrySet()) {
                        Player tempPlayer = entry.getKey();
                        Inscription tempInscription = entry.getValue();

                        if (tempPlayer.getId().equals(idPlayer)) {
                            inscription.remove(tempPlayer);
                            break;
                        }
                    }

                    System.out.println("Participante desinscrito correctamente.");
                    break;
                case 5:
                    for (HashMap.Entry<Player, Inscription> entry : inscription.entrySet()) {
                        Inscription tempInscription = entry.getValue();
                        switch (tempInscription.getCategory().getId()) {
                            case "1":
                                totalCategory += tempInscription.getAmount();
                                System.out.println("Total recaudado en categoría 1: " + totalCategory);

                                break;
                            case "2":
                                totalCategory += tempInscription.getAmount();
                                System.out.println("Total recaudado en categoría 2: " + totalCategory);

                                break;
                            case "3":
                                totalCategory += tempInscription.getAmount();
                                System.out.println("Total recaudado en categoría 3: " + totalCategory);

                        }
                    }

                    break;
                case 6:
                    op = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

        scn.close();
    }
}