package nirmittandel_sec001_ex01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account(1000);
        ArrayList<Transaction> transactions = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of transactions: ");
        int numTransactions = scanner.nextInt();
        scanner.nextLine(); // consume newline not consumed by nextInt()
      

        for (int i = 0; i < numTransactions; i++) {
            System.out.println("Enter the type of transaction (1 for deposit, 2 for withdrawal): ");
            int transactionType = scanner.nextInt();
            System.out.println("Enter the amount: ");
            int amount = scanner.nextInt();
            boolean isDeposit = transactionType == 1;
            transactions.add(new Transaction(account, amount, isDeposit));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(transactions.size());
        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }
        executorService.shutdown();
    }
}
