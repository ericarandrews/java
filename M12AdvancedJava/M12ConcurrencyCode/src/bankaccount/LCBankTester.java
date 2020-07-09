package bankaccount;

public class LCBankTester {

	public static void main(String[] args) throws InterruptedException {
		LCBankAccount account = new LCBankAccount();
		Thread despositThread = new Thread(new LCBankThread("DEPOSIT", account));
		Thread bonusThread = new Thread(new LCBankThread("BONUS", account));
		
		despositThread.start();
		bonusThread.start();
		
		despositThread.join();
		bonusThread.join();
		
		System.out.println(account);
		

	}

}
