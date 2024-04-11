package org.example;
import java.util.*;

public class App 
{
    private static Scanner input = new Scanner(System.in);
    private static List<Record> listRecords = new LinkedList<>();
    public static void main( String[] args )
    {

        boolean flag = true;
        while (flag){
            System.out.println("SISTEMA DE REGISTRO PARA LA CARRERA DE LA SELVA");
            System.out.println("INGRESA UNA OPCION A REALIZAR");
            System.out.println("1) PARA REGISTRAR A UN CORREDOR\n2) PARA MOSTRAR INSCRITOS\n3) PARA ELIMINAR UN CORREDOR\n4) PARA VER GANANCIAS");
            int opcion = input.nextInt();
            switch (opcion){
                case 1:
                    Record insertedRecord =  setRecord();
                    listRecords.add(insertedRecord);
                    break;
                case 2:
                    printRecords();
                    break;
                case 3:
                    System.out.print("Dame el id del registro: ");
                    int idToRemove = input.nextInt();
                    unRegisterRecord(idToRemove);
                    break;
                case 4:
                    printEarnings();
                    break;

            }
        }
    }

    private static Record setRecord () {
        // Create three categories
        Category category1 = new Category("Circuito chico", "2 km por selva y arroyos");
        Category category2 = new Category("Circuito mediano", "5 km por selva, arroyos y barro");
        Category category3 = new Category("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Obtain user name
        print("Nombre: ");
        String name = input.next();
        // Obtain user last name
        print("Apellido: ");
        String lastName = input.next();
        // Obtain user age
        print("Edad: ");
        int age = input.nextInt();
        // Obtain user DNI
        print("DNI: ");
        String dni = input.next();
        // Obtain user phone number
        print("Numero: ");
        String phone = input.next();
        // Obtain emergency user phone
        print("numero emergencia: ");
        String emergencyPhone = input.next();
        // Obtain user kind of blood
        print("tipo de sangre: ");
        String bloodType = input.next();

        // Creating a new runner instance
        Player newPlayer = new Player(dni, name, lastName, phone, emergencyPhone, bloodType, age);

        // Record instance declaration
        Record record = null;

        // Printing category choice menu
        print("ELIJA UNA CATEGORIA A INSCRIBIR: ");
        print("1) Circuito chico");
        print("2) Circuito mediano");
        print("3) Circuito avanzado");

        // Obtaining a user-choice input
        int opcion2 = input.nextInt();
        switch (opcion2) {
            case 1:
                record = new Record(newPlayer, category1, (age >= 18) ? 1500 : 1300);
                break;
            case 2:
                record = new Record(newPlayer, category2, (age >= 18) ? 2300 : 2000);
                break;
            case 3:
                if (age < 18) {
                    System.out.println("No se puede registrar a esta categoria");
                    break;
                }
                record = new Record(newPlayer, category3, 2800);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion2);

        }

        // Save User in list

        return record;
    }

    public static void printRecords(){
        for (Record record : listRecords){
            if(record.isRegistered())
            {
                record.printRecordInfo();
                System.out.println("______________________");
            }
        }
    }

    public static void unRegisterRecord(int id){
        for (Record record : listRecords){
            if( record.getRecordId() == id){
                listRecords.remove(record);
            }
        }
    }

    public static void printEarnings(){
        int totalEarnings = 0, category1Earnings = 0, category2Earnings = 0, category3Earnings = 0;
        for (Record record : listRecords){
            if(record.isRegistered()){
                switch(record.getUserCategory().getId()){
                    case 1:
                        category1Earnings += record.getQuantity();
                        totalEarnings += record.getQuantity();
                        break;
                    case 2:
                        category2Earnings += record.getQuantity();
                        totalEarnings += record.getQuantity();
                        break;
                    case 3:
                        category3Earnings += record.getQuantity();
                        totalEarnings += record.getQuantity();
                        break;
                }
            }
        }
        System.out.println("Cattegoria 1: " + category1Earnings + "\nCategoria 2: " + category2Earnings + "\nCategoria 3: " + category3Earnings);
        System.out.println("Total de earnings: " + totalEarnings);
    }

    public static void print(String message){
        System.out.println(message);
    }
}
