package bankaccount;

import java.text.NumberFormat;
import java.util.concurrent.locks.*;

public class LBankAccount {

    private double balance;
    private static final double FEE = 1;
    private static final double DEFAULT_EARNING_BONUS = 1;
    private double earningBonus;

    private Lock balanceLock, bonusLock;

    public LBankAccount() {
        balance = 0;
        earningBonus = DEFAULT_EARNING_BONUS;
        balanceLock = new ReentrantLock();
        bonusLock = new ReentrantLock();
    }

    public void setBonus(double earningBonus) {
        bonusLock.lock();
        try {
            this.earningBonus = earningBonus;
        } finally {
            bonusLock.unlock();
        }
    }

    public void addBonus() {
        bonusLock.lock();
        balanceLock.lock();
        try {
            balance += earningBonus;
        } finally {
            balanceLock.unlock();
            bonusLock.unlock();
        }
    }

    public void applyFee() {
        balanceLock.lock();
        try {
            balance -= FEE;
        } finally {
            balanceLock.unlock();
        }
    }
    
    public void deposit(double depositAmount) {
        balanceLock.lock();
        try {
            balance += depositAmount;
        } finally {
            balanceLock.unlock();
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
