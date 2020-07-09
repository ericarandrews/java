package bankaccount;

import java.util.*;

public class BankTester {

	public static void main(String[] args) throws InterruptedException {
		BankAccount account = new BankAccount();
		
		List<Thread> threadList = new ArrayList<>();
		
		Random generator = new Random();
		for(int i=0; i<1000; i++) {
		    int times = generator.nextInt(10);
		    Thread feeThread = new Thread(new BankThread("FEE", account, times));
		    Thread bonusThread = new Thread(new BankThread("BONUS", account, times));
		    threadList.add(feeThread);
		    threadList.add(bonusThread);
		}

		for(Thread thread : threadList) {
		    thread.start();
		}
		for(Thread thread : threadList) {
            thread.join();
        }
		
		
		System.out.println(account);
		

	}

}
