package bankaccount;

import java.util.Random;

public class LCBankThread implements Runnable {

	private String type;
	private LCBankAccount account;

	public LCBankThread(String type, LCBankAccount account) {
		this.type = type;
		this.account = account;
	}

	public void run() {
		if(type.equals("DEPOSIT")) {
			for(int i=0; i<10; i++) {
				Random generator = new Random();
				account.deposit(generator.nextInt(3000));
				try {
					Thread.sleep(100);
				} catch(InterruptedException ex) {}
			}
		} else if(type.equals("BONUS")) {
			account.addBonus();
		}
		
		
	}

}
