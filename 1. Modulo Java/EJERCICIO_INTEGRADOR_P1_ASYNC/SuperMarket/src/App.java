import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

        Customer customer1 = new Customer("Alfred", "Pascal", "1234");
        Customer customer2 = new Customer("Antonio", "Lee", "123");
        Customer customer3 = new Customer("Arturo", "Gonzales", "12");       
        List<Customer> customers = new LinkedList<>();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);


        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println("\n");
        customers.remove(customer1);

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your DNI: ");
        System.out.print("> ");
        
        final String dni = input.nextLine().trim();
        input.close();

        for (Customer customer : customers) {
            if (customer.getDni().equals(dni)) {
                System.out.println(customer);
                return;
            }
        }

        System.out.println("Usuario no encontrado!");
    }

}
