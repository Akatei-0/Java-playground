import java.util.ArrayList;
import java.util.List;

public class ProductsManager {
    private List<Product> products;
    
    public ProductsManager() {
        products = new ArrayList<>();
    }
    
    public void addProduct(String title, double price) {
        Product product = new Product(title, price);
        products.add(product);
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public Product getTheMostExpensiveProduct() {
        double maxPrice = 0;
        int indexOfMax = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > maxPrice) {
                maxPrice = products.get(i).getPrice();
                indexOfMax = i;
            }
        }
        return products.get(indexOfMax);
    }

    public List<Product> getSortedProducts(double min, double max) {
        List<Product> sortedProducts = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            double price = products.get(i).getPrice();

            if (price >= min && price <= max) {sortedProducts.add(products.get(i));}
        }
        return sortedProducts;
    }


}
