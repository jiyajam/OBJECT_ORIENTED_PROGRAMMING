import java.util.*;

public class GroceryListManager {
    private Map<String, GroceryItem> groceryList = new HashMap<>();

    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists. Updating quantity.");
            updateQuantity(item, groceryList.get(item).getQuantity() + quantity);
        } else {
            groceryList.put(item, new GroceryItem(item, cost, category, quantity));
        }
    }

    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {
            System.out.println(item + " removed from the list.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        int index = 1;
        for (GroceryItem item : groceryList.values()) {
            System.out.println(index + ". " + item);
            index++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (GroceryItem item : groceryList.values()) {
            total += item.getCost() * item.getQuantity();
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (GroceryItem item : groceryList.values()) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
            }
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        GroceryItem i = groceryList.get(item);
        if (i != null) {
            i.setQuantity(newQuantity);
        } else {
            System.out.println("Item not found: " + item);
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (GroceryItem item : groceryList.values()) {
            if (item.getQuantity() > 0) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.0, "Fruits", 3);
        manager.addItem("Milk", 0.7, "Dairy", 2);
        manager.addItem("Bread", 3.2, "Bakery", 1);

        manager.displayList();

        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println("\nUpdated Grocery List:");
        manager.displayList();

        System.out.println("\nTotal Cost: $" + manager.calculateTotalCost());


//        System.out.println("\nItems in Fruits category:");
        manager.displayByCategory("Fruits");

        System.out.println("\nUpdating quantity of Apples to 10...");
        manager.updateQuantity("Apples", 10);

//        System.out.println("\nAvailable Items:");
        manager.displayAvailableItems();
    }
}
