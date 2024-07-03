# JavaFX-Application-with-Concurrency-and-Stream-API
This assignment demonstrates various concepts in Java, including JavaFX for creating graphical user interfaces, concurrency with synchronized methods, and the use of the Stream API for sorting and filtering collections.
**Components:**

1. **JavaFX Application (`Scene.fxml`):**
   - Provides a UI to calculate factorials asynchronously and perform car loan calculations.

2. **Concurrency with Synchronized Methods:**
   - **Account.java:** Represents a bank account with thread-safe deposit and withdrawal methods.
   - **AccountTest.java:** Tests the `Account` class by creating and executing concurrent transactions using `ExecutorService`.
   - **Transaction.java:** Represents a transaction on an `Account` (either deposit or withdrawal).

3. **Stream API for Sorting and Filtering:**
   - **Invoice.java:** Represents an invoice with various attributes.
   - **InvoiceTest.java:** Demonstrates sorting and filtering invoices using Stream API. It includes:
     - Sorting invoices by part description.
     - Sorting invoices by price per item.
     - Sorting part descriptions and quantities.
     - Sorting invoices by total value.
     - Filtering invoices with values between $200 and $500.
     - Finding invoices with part descriptions containing the word "saw".

This assignment provides a comprehensive overview of handling concurrent operations in Java and utilizing the powerful features of the Stream API to manipulate collections efficiently.
