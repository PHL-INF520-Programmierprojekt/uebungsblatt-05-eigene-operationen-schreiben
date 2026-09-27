package de.phl.programmingproject.banking;

public class BankAccount {
    private double balance;
    private final int accountNumber;

    /**
     * Creates a new bank account with the given balance and account number.
     *
     * @param balance the balance
     * @param accountNumber the account number
     * @throws IllegalArgumentException if the balance or account number is less than 0
     */
    public BankAccount(final double balance, final int accountNumber) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than 0");
        }
        if (accountNumber < 0) {
            throw new IllegalArgumentException("Account number must be greater than 0");
        }
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Deposits the given amount to the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is less than 0
     */
    public void deposit(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }
        balance += amount;
    }

    /**
     * Hebt den Betrag ab. In diesem Übungsmodell sind Überziehungen erlaubt.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException wenn der Betrag negativ ist
     */
    public void withdraw(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account number: %d, Balance: %f", accountNumber, balance);
    }

    public static void main(String[] args) {
        // TODO Implement this operation to test the operations you implemented
    }
}
