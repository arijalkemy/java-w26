package view;
import java.util.Scanner;

import view.options.IOption;

public class View {
    
    public static String requestAction(String ...request)
    {
        System.out.println("Digite una opción del menu:");
        for (String string : request) {
            System.out.println(string);
        }
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        return input;
    }

    public static IOption requestAction(IOption ... action)
    {
        System.out.println("Cantidad de opciones: " + action.length);
        System.out.println("Digite una opción del menu:");
        for (IOption iOption : action) {
            iOption.showAction();
        }
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (IOption iOption : action) {
            if (iOption.getId().equals(input)) {
                return iOption;
            }
        }
        scanner.close();
        return null;
    }

}
