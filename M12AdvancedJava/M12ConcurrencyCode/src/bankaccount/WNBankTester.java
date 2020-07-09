package bankaccount;

import java.util.*;

public class WNBankTester {

	public static void main(String[] args) throws InterruptedException {
		WNBankAccount account = new WNBankAccount();
		
		List<Thread> threadList = new ArrayList<>();

        Random generator = new Random();
		for(int i=0; i<5; i++) {
		    Thread depositThread = new Thread(new WNBankThread("DEPOSIT", account, generator.nextInt(1000)));
		    depositThread.setName("Deposit Thread " + i);
		    threadList.add(depositThread);
		}		    

		threadList.add(new Thread(new WNBankThread("BONUS", account, 500), "Bonus Thread 500"));
		threadList.add(new Thread(new WNBankThread("BONUS", account, 1000), "Bonus Thread 1000"));
		threadList.add(new Thread(new WNBankThread("BONUS", account, 2000), "Bonus Thread 2000"));
		
		for(Thread thread : threadList) {
		    thread.start();
		}

	

	}

}
