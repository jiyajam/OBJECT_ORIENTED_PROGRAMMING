package application;

import view.CurrencyConverterView;
import datasource.MariadbConnect;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Currency Converter!");

        // Test database connection
        try {
            MariadbConnect.getConnection();
            System.out.println("Database connection successful.");
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }

        CurrencyConverterView.launch(CurrencyConverterView.class, args);

        // Clean up database connection when application exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MariadbConnect.terminate();
            System.out.println("Database connection closed.");
        }));
    }
}
