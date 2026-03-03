package MiniProject;

public class Dog extends Pet implements ITrainable {
    private String breed;

    public Dog(String id, String name, int age, double price, String breed) {
        super(id, name, age, price);
        this.breed = breed;
    }

    @Override
    public void makeSound() { System.out.println("Dog sủa: Woof Woof!"); }

    @Override
    public void performTrick() { System.out.println("Dog " + name + " đang lăn vòng!"); }
}
