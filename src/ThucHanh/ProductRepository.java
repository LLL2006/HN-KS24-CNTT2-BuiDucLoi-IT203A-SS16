package ThucHanh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class ProductRepository implements IRepository<Product>{
    private List<Product> productList = new ArrayList<>(); // Lưu danh sách
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || productMap.containsKey(item.getId())) return false;
        productList.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        Product p = productMap.remove(id);
        if (p != null) {
            return productList.remove(p);
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }
}
