package bankaccount;

import java.text.NumberFormat;
import java.util.concurrent.locks.*;

public class LCBankAccount {

    private double balance;
    private static final double FEE = 1;
    private static final double BONUS = 100;

    public static final double BONUS_THRESHOLD = 5000;

    private Lock bankLock;
    private Condition bonusCondition;

    public LCBankAccount() {
        balance = 0;
        bankLock = new ReentrantLock();
        bonusCondition = bankLock.newCondition();
    }

    public void deposit(double depositAmount) {
        bankLock.lock();
        try {
            if (depositAmount > 0) {
                System.out.println("BEFORE DEPOSIT: Balance is " + balance);
                balance += depositAmount;
                System.out.println("AFTER DEPOSIT: Balance is " + balance);

                bonusCondition.signalAll();
            }
        } finally {
            bankLock.unlock();
        }
    }

    public void addBonus() {
        bankLock.lock();
        try {
            while (balance < BONUS_THRESHOLD) {
                System.out.println("INSIDE BONUS WHILE LOOP");
                bonusCondition.await();
            }
            System.out.println("BEFORE BONUS: Balance is " + balance);
            balance += BONUS;
            System.out.println("AFTER BONUS: Balance is " + balance);
        } catch (InterruptedException ex) {
        } finally {
            bankLock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return NumberFormat.getCurrencyInstance().format(balance);
    }

}
