package MiniProject;

public abstract class Pet {
    protected String id;
    protected String name;
    protected int age;
    protected double price;
    public static int totalPets = 0; // Biến static đếm tổng số pet

    public Pet(String id, String name, int age, double price) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.price = price;
        totalPets++; // Tăng tổng số khi khởi tạo
    }

    public abstract void makeSound(); // Phương thức trừu tượng

    public void displayInfo() {
        System.out.println(id + " | " + name + " | " + age + " tuổi | Giá: " + price);
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getPrice() { return price; }
}
