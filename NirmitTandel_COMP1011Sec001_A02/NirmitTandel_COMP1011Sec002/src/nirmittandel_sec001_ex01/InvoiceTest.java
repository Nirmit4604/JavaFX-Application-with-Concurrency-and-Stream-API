package nirmittandel_sec001_ex01;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class InvoiceTest {

    public static void main(String[] args) {
        // Initialize an array of Invoice objects with sample data
        Invoice[] invoices = {
            new Invoice("87", "Electric Sander", 7, 57.98),
            new Invoice("24", "Power saw", 18, 99.99),
            new Invoice("7", "Sledge Hammer", 11, 21.50),
            new Invoice("77", "Hammer", 76, 11.99),
            new Invoice("39", "Lawn Mower", 3, 79.50),
            new Invoice("68", "Screw Driver", 106, 6.99),
            new Invoice("56", "Jig saw", 21, 11.00),
        };

        // Run query a
        System.out.println("Query a: Sort invoices by partDescription");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(invoice -> invoice.getPartDescription()))
                .forEach(invoice -> System.out.println(invoice));

        // Run query b
        System.out.println("\nQuery b: Sort invoices by pricePerItem");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPricePerItem))
                .forEach(invoice -> System.out.println(invoice));

        // Run query c
        System.out.println("\nQuery c: Sort partDescription and quantity");
        Arrays.stream(invoices)
                .map(invoice -> new AbstractMap.SimpleEntry<>(invoice.getPartDescription(), invoice.getQuantity()))
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        // Run query d
        System.out.println("\nQuery d: Sort invoices by value (quantity * pricePerItem)");
        Arrays.stream(invoices)
                .map(invoice -> new AbstractMap.SimpleEntry<>(invoice.getPartDescription(), invoice.getInvoiceAmount()))
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue())));

        // Run query e
        System.out.println("\nQuery e: Filter invoices by value between $200 and $500");
        Arrays.stream(invoices)
                .map(invoice -> new AbstractMap.SimpleEntry<>(invoice.getPartDescription(), invoice.getInvoiceAmount()))
                .filter(entry -> entry.getValue() >= 200 && entry.getValue() <= 500)
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue())));

        // Run query f
        System.out.println("\nQuery f: Find any invoice with partDescription containing 'saw'");
        Arrays.stream(invoices)
                .filter(invoice -> invoice.getPartDescription().contains("saw"))
                .forEach(invoice -> System.out.println(invoice));
    }
}
