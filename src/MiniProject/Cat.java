package MiniProject;

public class Cat extends Pet implements ITrainable {
    private String color;

    public Cat(String id, String name, int age, double price, String color) {
        super(id, name, age, price);
        this.color = color;
    }

    @Override
    public void makeSound() { System.out.println("Cat kêu: Meow!"); }

    @Override
    public void performTrick() { System.out.println("Cat " + name + " đang nhảy qua vòng!"); }
}
