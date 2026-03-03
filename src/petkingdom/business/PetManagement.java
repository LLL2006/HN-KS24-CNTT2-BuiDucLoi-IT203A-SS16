package petkingdom.business;

import petkingdom.model.Client;
import petkingdom.model.Pet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PetManagement implements IManagement<Pet> {
    public static List<Pet> pets = new ArrayList<>();

    public boolean isEmpty() {
        return pets.isEmpty();
    }
    @Override
    public boolean add(Pet item) {
        Pet findPet = findById(item.getId());
        if(findPet == null){
            return pets.add(item);
        }
        return false;
    }

    public void displayAll() {
        System.out.println("+----------------------+");
        System.out.printf("|%-5s|%-10s|%-5s|\n","ID","Name","Type");
        System.out.println("+----------------------+");
        for(Pet item : pets){
            System.out.print(item.toString());
            System.out.println("+----------------------+");
        }
    }

    @Override
    public Pet findById(String id) {
        for(Pet item : pets){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public boolean delete(String petId) {
        for(Pet item : pets){
            if(item.getId().equals(petId)){
                pets.remove(item);
                return true;
            }
        }
        return false;
    }
}
