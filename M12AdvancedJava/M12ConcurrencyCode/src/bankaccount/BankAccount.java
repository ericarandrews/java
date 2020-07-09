package bankaccount;

import java.text.NumberFormat;

public class BankAccount {

    private static final double FEE = 1;
    private static final double BONUS = 1;

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public synchronized double getBalance() {
        return balance;
    }

    // adding "synchronized" to the methods prevent the race condition
    public synchronized void applyFee() {
        balance -= FEE;
    }

    public synchronized void addBonus() {
        balance += BONUS;
    }

    @Override
    public synchronized String toString() {
        return NumberFormat.getCurrencyInstance().format(balance);
    }

}
