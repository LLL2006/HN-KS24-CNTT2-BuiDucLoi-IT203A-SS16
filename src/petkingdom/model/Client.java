package petkingdom.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String id;
    private String name;
    private String phoneNumber;
    private List<Pet> pets;
    public Client(String id, String name,String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        pets = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        if(pets != null){
            this.pets.add(pet);
        }
    }

    public Pet findPetById(String id){
        for(Pet pet:pets){
            if(pet.getId().equals(id)){
                return pet;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) || Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,phoneNumber);
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-15s|%-15s|\n",this.id,this.name,this.phoneNumber);
    }
}
