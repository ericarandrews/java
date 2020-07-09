package bankaccount;

import java.util.Random;

public class BankThread implements Runnable {

    private String type;
    private BankAccount account;
    private int times;

    public BankThread(String type, BankAccount account, int times) {
        this.type = type;
        this.account = account;
        this.times = times;
    }

    @Override
    public void run() {
        Random generator = new Random();
        for (int i = 0; i < times; i++) {
            if (type.equals("FEE")) {
                account.applyFee();
            } else if (type.equals("BONUS")) {
                account.addBonus();
            }
            try {
                int time = generator.nextInt(2);
                Thread.sleep(time);
            } catch (InterruptedException ex) {
            }
        }
    }

}
