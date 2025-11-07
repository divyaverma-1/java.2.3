import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " | " + category + " | Price: " + price;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Smartphone", 50000, "Electronics"),
            new Product("Headphones", 2500, "Electronics"),
            new Product("Shirt", 1200, "Clothing"),
            new Product("Jeans", 2000, "Clothing"),
            new Product("Mixer", 3500, "Home Appliances"),
            new Product("Fridge", 45000, "Home Appliances")
        );

        // Group by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Grouped by Category:");
        grouped.forEach((cat, list) -> {
            System.out.println(cat + " -> " + list);
        });

        // Most expensive product in each category
        Map<String, Optional<Product>> maxPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost Expensive Product in Each Category:");
        maxPriceByCategory.forEach((cat, prod) -> 
            System.out.println(cat + " -> " + prod.get().name + " (" + prod.get().price + ")")
        );

        // Average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
