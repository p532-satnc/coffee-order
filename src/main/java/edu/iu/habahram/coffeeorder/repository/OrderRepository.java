package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class OrderRepository {
    private static final String DB_FILE = "db.txt";
    private static int lastId = loadLastId();

    private static void saveToDatabase(Receipt receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_FILE, true))) {
            writer.write(receipt.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save receipt to database", e);
        }
    }

    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = switch (order.beverage().toLowerCase()) {
            case "dark roast" -> new DarkRoast();
            case "decaf" -> new Decaf();
            case "espresso" -> new Espresso();
            case "house blend" -> new HouseBlend();
            default -> throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        };
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            beverage = switch (condiment.toLowerCase()) {
                case "milk" -> new Milk(beverage);
                case "mocha" -> new Mocha(beverage);
                case "soy" -> new Soy(beverage);
                case "whip" -> new Whip(beverage);
                default -> throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            };
        }

        Receipt receipt = new Receipt(++lastId, beverage.getDescription(), beverage.cost());

        saveToDatabase(receipt);
        return receipt;

    }

    private static int loadLastId() {
        int lastId = 0; 

        try (BufferedReader reader = new BufferedReader(new FileReader(DB_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length > 0) {
                    try {
                        
                        lastId = Integer.parseInt(parts[0]);  
                    } catch (NumberFormatException ignored) {
                        
                    }
                }
            }
        } catch (IOException e) {
            // Log or print an error message if the file can't be read
            System.err.println("Error reading the database file: " + e.getMessage());
        }

        return lastId;
    }
}
