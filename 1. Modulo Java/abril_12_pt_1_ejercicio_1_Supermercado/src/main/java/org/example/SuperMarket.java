package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SuperMarket
{
    private List<Client> clients;
    public SuperMarket(){
        clients = new ArrayList<>();
    }

    public void addClient(String name, String lastName, String dni){
        clients.add(new Client(name, lastName, dni));
    }

    public void deleteClient(String dni){
        clients.removeIf(client -> client.getDni().equals(dni));
    }
    public void findClientByDni(String dni){

        for (Client client : clients){
            if(client.getDni().equals(dni)){
                System.out.println(client.getName() + " found");
                break;
            }
            else{
                System.out.println("Client not fount");
            }
        }
    }

    public void showClients(){
        for(Client client: clients){
            System.out.println("Client Name: " + client.getName());
            System.out.println("Client Name: " + client.getLastName());
            System.out.println("Client Name: " + client.getDni());
        }
    }
}
