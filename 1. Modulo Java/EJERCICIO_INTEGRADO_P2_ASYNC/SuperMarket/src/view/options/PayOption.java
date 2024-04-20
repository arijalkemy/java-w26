package view.options;

import java.util.List;
import java.util.Scanner;

import api.API;
import api.APISuperMarket;
import data.ShoppingCarRepository;
import models.Bill;
import models.Product;
import view.MainMenu;

public class PayOption extends AbstractOption {
    public PayOption()
    {
        this.id = 2;
    }
    @Override
    public void execAction() {
        API apiConnection = APISuperMarket.getInstance();
        List<Product> shoppingCar = ShoppingCarRepository.getShoppingCar();

        System.out.println("Estos son los elementos que pagaras: ");
        System.out.println(ShoppingCarRepository.getShoppingCar());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite su DNI para crear su factura");
        System.out.print("> ");
        
        String dni = scanner.nextLine();

        int responseCreationBill = apiConnection.createBill(dni, shoppingCar); 
        
        if (responseCreationBill == -1) {
            System.out.println("Su usuario no existe. Para registrarse digite lo siguiente: ");

            System.out.println("Digite su Nombre");
            System.out.print("> ");
            String nombre = scanner.nextLine();

            System.out.println("Digite su Apellido");
            System.out.print("> ");
            String apellido = scanner.nextLine();
            
            boolean responseCreationCustomer = apiConnection.createCustomer(dni, nombre, apellido);
            System.out.println("Customer status:"+ responseCreationCustomer);     
            if (responseCreationCustomer) {
                responseCreationBill = apiConnection.createBill(dni, shoppingCar);
            }
        }

        Bill bill = apiConnection.getBill(responseCreationBill);
        System.out.println(bill);
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
        MainMenu mainMenu = new MainMenu();
        mainMenu.execAction();
    }

    @Override
    public void showAction() {
        System.out.println(this.id + ". Pagar.");
    }

}
