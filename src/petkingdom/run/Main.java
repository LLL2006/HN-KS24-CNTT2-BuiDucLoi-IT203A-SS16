package petkingdom.run;

import petkingdom.business.ClientManagement;
import petkingdom.business.PetManagement;
import petkingdom.business.ServiceManagement;
import petkingdom.model.Client;
import petkingdom.model.Pet;

import java.util.Scanner;

public class Main {
    public static PetManagement petManagement = new PetManagement();
    public static ServiceManagement serviceManagement = new ServiceManagement();
    public static ClientManagement clientManagement = new ClientManagement();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        run(sc);
        sc.close();
    }

    public static void run(Scanner sc){
        initData();
        View.showMenu(sc);
    }

    public static void initData(){
        Client c1 = new Client("C001", "Nguyen Van A", "0901234567");
        c1.addPet(new Pet("P001", "KiKi", "Dog"));
        c1.addPet(new Pet("P002", "Meo Meo", "Cat"));
        Client c2 = new Client("C002", "Le Thi B", "0988888888");
        c2.addPet(new Pet("P003", "LuLu", "Dog"));
        Client c3 = new Client("C003", "Tran Van C", "0912333444");
        clientManagement.add(c1);
        clientManagement.add(c2);
        clientManagement.add(c2);
        clientManagement.add(c3);
        Pet p1 = new Pet("P001", "KiKi", "Dog");
        Pet p2 = new Pet("P002", "Mimi", "Cat");
        Pet p3 = new Pet("P003", "LuLu", "Dog");
        Pet p4 = new Pet("P004", "Ngao", "Husky");
        Pet p5 = new Pet("P005", "Muop", "Cat");
        Pet p6 = new Pet("P006", "Bunny", "Cat");
        Pet p7 = new Pet("P007", "Jerry", "Cat");
        Pet p8 = new Pet("P008", "Mickey", "Cat");
        Pet p9 = new Pet("P009", "Parrot", "Bird");
        Pet p10 = new Pet("P010", "Chirp", "Bird");
        petManagement.add(p1);
        petManagement.add(p2);
        petManagement.add(p3);
        petManagement.add(p4);
        petManagement.add(p5);
        petManagement.add(p6);
        petManagement.add(p7);
        petManagement.add(p8);
        petManagement.add(p9);
        petManagement.add(p10);
    }
}
