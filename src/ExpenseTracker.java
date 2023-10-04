import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return description + ": $" + amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter expense amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    expenses.add(new Expense(description, amount));
                    System.out.println("Expense added.");
                    break;
                case 2:
                    System.out.println("Expenses:");
                    for (int i = 0; i < expenses.size(); i++) {
                        System.out.println((i + 1) + ". " + expenses.get(i));
                    }
                    break;
                case 3:
                    double totalExpenses = 0;
                    for (Expense expense : expenses) {
                        totalExpenses += expense.amount;
                    }
                    System.out.println("Total Expenses: $" + totalExpenses);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
