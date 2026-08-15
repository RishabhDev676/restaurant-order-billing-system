package com.restaurant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuManager {
    public static class MenuItem {
        private final String name;
        private final double price;
        private final String category;

        public MenuItem(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }
    }

    private final List<MenuItem> menuList = new ArrayList<>();
    private final Map<String, List<MenuItem>> categorizedMenu = new LinkedHashMap<>();

    public MenuManager() {
        // Main Course
        addItem("Paneer Butter Masala", 180.0, "Main Course");
        addItem("Veg Biryani", 150.0, "Main Course");
        addItem("Chicken Biryani", 220.0, "Main Course");
        addItem("Butter Chicken", 250.0, "Main Course");
        addItem("Fish Curry", 300.0, "Main Course");
        addItem("Mutton Curry", 350.0, "Main Course");
        addItem("Dal Tadka", 100.0, "Main Course");
        addItem("Roti", 20.0, "Main Course");
        addItem("Naan", 40.0, "Main Course");

        // South Indian
        addItem("Masala Dosa", 100.0, "South Indian");
        addItem("Idli Sambar", 80.0, "South Indian");

        // Fast Food & Snacks
        addItem("Chole Bhature", 120.0, "Fast Food");
        addItem("Pav Bhaji", 110.0, "Fast Food");
        addItem("Fried Rice", 130.0, "Fast Food");
        addItem("Noodles", 140.0, "Fast Food");
        addItem("Manchurian", 160.0, "Fast Food");

        // Beverages & Desserts
        addItem("Cold Coffee", 90.0, "Beverages & Desserts");
        addItem("Ice Cream", 70.0, "Beverages & Desserts");
        addItem("Soft Drink", 50.0, "Beverages & Desserts");
        addItem("Gulab Jamun", 60.0, "Beverages & Desserts");
    }

    private void addItem(String name, double price, String category) {
        MenuItem item = new MenuItem(name, price, category);
        menuList.add(item);
        categorizedMenu.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
    }

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("All Categories");
        categories.addAll(categorizedMenu.keySet());
        return categories;
    }

    public List<MenuItem> getItemsByCategory(String category) {
        if ("All Categories".equals(category) || category == null) {
            return menuList;
        }
        return categorizedMenu.getOrDefault(category, new ArrayList<>());
    }

    public Double getPrice(String itemName) {
        for (MenuItem item : menuList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item.getPrice();
            }
        }
        return 0.0;
    }
}
