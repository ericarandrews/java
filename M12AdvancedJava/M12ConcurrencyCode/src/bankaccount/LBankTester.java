package bankaccount;

public class LBankTester {

	public static void main(String[] args) throws InterruptedException {
		LBankAccount account = new LBankAccount();
		Thread feeThread = new Thread(new LBankThread("FEE", account));
		Thread bonusThread = new Thread(new LBankThread("BONUS", account));

		feeThread.start();
		bonusThread.start();

		feeThread.join();
		bonusThread.join();

		System.out.println(account);
		
	}

}
