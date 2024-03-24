package com.abhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define Account class
class Account {
    private int accountId;
    private String accountHolderName;
    private double balance;

    public Account(int accountId, String accountHolderName, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

// Define Bank class
class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // Create some sample accounts
        bank.addAccount(new Account(1001, "Alice", 5000));
        bank.addAccount(new Account(1002, "Bob", 3000));

        // Interactive menu
        while (true) {
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account ID: ");
                    int accountId = scanner.nextInt();
                    Account depositAccount = bank.getAccountById(accountId);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amountToDeposit = scanner.nextDouble();
                        depositAccount.deposit(amountToDeposit);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    int withdrawAccountId = scanner.nextInt();
                    Account withdrawAccount = bank.getAccountById(withdrawAccountId);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amountToWithdraw = scanner.nextDouble();
                        withdrawAccount.withdraw(amountToWithdraw);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
