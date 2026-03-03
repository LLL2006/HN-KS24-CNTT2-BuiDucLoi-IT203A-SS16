package MiniProject;
import java.util.*;

public class PetKingdomSystem {
    public static void main(String[] args) {
        // Khởi tạo các Collections
        List<Pet> petList = new ArrayList<>();        // Quản lý đa hình
        Map<String, Pet> petMap = new HashMap<>();    // Tra cứu nhanh O(1)
        Set<String> petNames = new HashSet<>();       // Tránh trùng tên

        System.out.println("=== PET KINGDOM SYSTEM ===\n");

        // 1. Thêm thú cưng (Kiểm tra trùng tên bằng Set)
        addPetToList(new Dog("D01", "Buddy", 3, 200.0, "Poodle"), petList, petMap, petNames);
        addPetToList(new Cat("C02", "Kitty", 2, 180.0, "White"), petList, petMap, petNames);

        // 2. Anonymous Class - Parrot
        Pet parrot = new Pet("P03", "Rio", 2, 150.0) {
            @Override
            public void makeSound() {
                System.out.println("Parrot Rio nói: Xin chào!");
            }
        };
        addPetToList(parrot, petList, petMap, petNames);

        System.out.println("Đã khởi tạo " + Pet.totalPets + " thú cưng.\n");

        // --- Danh sách ban đầu ---
        System.out.println("--- Danh sách ban đầu ---");
        petList.forEach(Pet::displayInfo);

        // 3. Sắp xếp theo giá (Comparator + Lambda)
        petList.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\n--- Sau khi sắp xếp theo giá (Tăng dần) ---");
        petList.forEach(p -> System.out.println(p.getName() + " - " + p.getPrice()));

        // 4. Tìm kiếm nhanh theo ID (HashMap)
        String searchId = "C02";
        System.out.println("\n--- Tìm theo ID: " + searchId + " ---");
        Pet found = petMap.get(searchId);
        if (found != null) {
            System.out.print("Tìm thấy: ");
            found.displayInfo();
        }

        // 5. Xóa pet lớn tuổi (>10) dùng Iterator
        Iterator<Pet> iterator = petList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAge() > 10) {
                iterator.remove();
            }
        }

        // 6. Biểu diễn kỹ năng (ITrainable)
        System.out.println("\n--- Biểu diễn kỹ năng ---");
        for (Pet p : petList) {
            if (p instanceof ITrainable) {
                ((ITrainable) p).performTrick();
            }
        }

        System.out.println("\nTổng số thú cưng đã tạo (static): " + Pet.totalPets);
    }

    // Phương thức hỗ trợ thêm Pet và kiểm tra trùng tên
    public static void addPetToList(Pet p, List<Pet> list, Map<String, Pet> map, Set<String> names) {
        if (names.contains(p.getName())) {
            System.out.println("Lỗi: Tên '" + p.getName() + "' đã tồn tại!");
        } else {
            list.add(p);
            map.put(p.getId(), p);
            names.add(p.getName());
        }
    }
}
