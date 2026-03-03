package petkingdom.business;

import petkingdom.model.Client;
import petkingdom.model.Pet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClientManagement implements IManagement<Client> {
    public static Set<Client> clients = new LinkedHashSet<>();

    public static boolean isEmpty(){
        return clients.isEmpty();
    }

    @Override
    public boolean add(Client item) {
        return clients.add(item);
    }

    @Override
    public Client findById(String id){
        for(Client c : clients){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public static void displayClient(Client client){
        System.out.println("+-------------------------------------+");
        System.out.printf("|%-5s|%-15s|%-15s|\n","ID","Name","Phone Number");
        System.out.println("+-------------------------------------+");
        System.out.printf(client.toString());
        System.out.println("+-------------------------------------+");
    }
}
