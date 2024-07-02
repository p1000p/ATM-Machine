import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    public Account(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + initialBalance);
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactionHistory.add("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        transactionHistory.add("PIN changed.");
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

class ATM {
    private Map<Integer, Account> accounts;

    public ATM() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(int accountNumber, double initialBalance, int initialPin) {
        accounts.put(accountNumber, new Account(initialBalance, initialPin));
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void displayAccountNumbers() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts");
        } else {
            System.out.println("Account Numbers:");
            for (int accountNumber : accounts.keySet()) {
                System.out.println("Account No. "+accountNumber);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        while (true) {
            System.out.println("\nATM Main Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Enter Account Number");
            System.out.println("3. View All Account Numbers");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    System.out.print("Enter new account number: ");
                    int newAccountNumber = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    System.out.print("Enter initial PIN: ");
                    int initialPin = scanner.nextInt();
                    atm.createAccount(newAccountNumber, initialBalance, initialPin);
                    System.out.println("Account created successfully. Your account number is: " + newAccountNumber);
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    int accountNumber = scanner.nextInt();
                    Account account = atm.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Please enter your PIN: ");
                        int enteredPin = scanner.nextInt();
                        if (account.verifyPin(enteredPin)) {
                            boolean exit = false;
                            while (!exit) {
                                System.out.println("\nATM Menu:");
                                System.out.println("1. Check Balance");
                                System.out.println("2. Deposit Cash");
                                System.out.println("3. Withdraw Cash");
                                System.out.println("4. Change PIN");
                                System.out.println("5. View Transaction History");
                                System.out.println("6. Exit");
                                System.out.print("Choose an option: ");

                                int choice = scanner.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.println("Your balance is: " + account.getBalance());
                                        break;
                                    case 2:
                                        System.out.print("Enter deposit amount: ");
                                        double depositAmount = scanner.nextDouble();
                                        account.deposit(depositAmount);
                                        break;
                                    case 3:
                                        System.out.print("Enter withdrawal amount: ");
                                        double withdrawalAmount = scanner.nextDouble();
                                        account.withdraw(withdrawalAmount);
                                        break;
                                    case 4:
                                        System.out.print("Enter new PIN: ");
                                        int newPin = scanner.nextInt();
                                        account.changePin(newPin);
                                        break;
                                    case 5:
                                        account.printTransactionHistory();
                                        break;
                                    case 6:
                                        exit = true;
                                        System.out.println("Thank you for using the ATM. Goodbye!");
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            }
                        } else {
                            System.out.println("Incorrect PIN. Access denied.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    atm.displayAccountNumbers();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
