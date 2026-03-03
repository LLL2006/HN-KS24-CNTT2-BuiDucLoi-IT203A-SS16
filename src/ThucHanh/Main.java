package ThucHanh;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("EP01", "iPhone 16", 22000000, 24));
        repo.add(new ElectronicProduct("EP02", "iPhone 15", 8000000, 12));
        repo.add(new FoodProduct("FP01", "Bánh mì", 20000, 10));
        repo.add(new FoodProduct("FP02", "Bánh chưng", 50000, 5));

        for (Product p : repo.findAll()) {
            p.displayInfo();
            System.out.printf(" | Thành tiền: %,.0f VNĐ\n", p.calculateFinalPrice());
        }

        String searchId = "EP01";
        Product found = repo.findById(searchId);
        System.out.println("\nTìm kiếm ID: " + searchId);
        if (found != null) {
            found.displayInfo();
        } else {
            System.out.println("Không tìm thấy");
        }

        List<Product> allProducts = repo.findAll();
        allProducts.sort(Comparator.comparingDouble(p -> p.getPrice()));
        System.out.println("Thống kê sản phẩm");
        allProducts.forEach(p -> System.out.printf("\n%s: %,.0f VNĐ", p.name, p.price));

        Map<String, Integer> stats = new HashMap<>();
        stats.put("Electronic", 0);
        stats.put("Food", 0);

        for (Product p : repo.findAll()) {
            if (p instanceof ElectronicProduct) {
                stats.put("Electronic", stats.get("Electronic") + 1);
            } else if (p instanceof FoodProduct) {
                stats.put("Food", stats.get("Food") + 1);
            }
        }
        System.out.println("\n" + stats);
    }
}
