import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name, category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + category + " - Price: " + price;
    }
}

public class ProductStream {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1000),
            new Product("Phone", "Electronics", 700),
            new Product("TV", "Electronics", 1200),
            new Product("Shoes", "Fashion", 100),
            new Product("Jeans", "Fashion", 50),
            new Product("Washing Machine", "Appliances", 500)
        );

        // Group by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        
        System.out.println("\nProducts Grouped by Category:");
        groupedByCategory.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        // Find most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category, 
                    Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.get()));

        // Calculate average price
        double avgPrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0);

        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}