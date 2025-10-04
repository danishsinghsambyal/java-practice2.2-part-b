import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Comparator;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " - " + category + " ($" + price + ")";
    }
}

public class ProductStreamOps {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 80000, "Electronics"),
                new Product("Phone", 50000, "Electronics"),
                new Product("Shirt", 2000, "Clothing"),
                new Product("Jeans", 3000, "Clothing"),
                new Product("Bread", 50, "Food"),
                new Product("Milk", 60, "Food")
        );

        // 1. Group products by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products Grouped by Category:");
        grouped.forEach((cat, list) -> {
            System.out.println(cat + " -> " + list);
        });

        // 2. Most expensive product in each category
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost Expensive Product in Each Category:");
        maxByCategory.forEach((cat, prod) -> System.out.println(cat + " -> " + prod.get()));

        // 3. Average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
