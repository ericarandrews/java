package bankaccount;

import java.text.NumberFormat;

public class WNBankAccount {

	private int balance;
	private static final double EARNING_BONUS=1;

	public WNBankAccount() {
		balance = 0;
	}

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void deposit(int depositAmount) {
		if(depositAmount>=0) {
			System.out.println("BEFORE DEPOSIT: Balance is " + balance + " with thread " + Thread.currentThread().getName());
			balance += depositAmount;
			System.out.println("AFTER DEPOSIT: Balance is " + balance + " with thread " + Thread.currentThread().getName());
		}
	}
	
	public synchronized void applyBonus() {
	    System.out.println("BEFORE BONUS: Balance is " + balance + " with thread " + Thread.currentThread().getName());
	    balance += EARNING_BONUS;
	    System.out.println("AFTER BONUS: Balance is " + balance + " with thread " + Thread.currentThread().getName());
	}


	
	@Override
	public String toString() {
		return NumberFormat.getCurrencyInstance().format(balance);
	}
	
	
}
