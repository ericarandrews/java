package bankaccount;

public class WNBankThread implements Runnable {

    private String type;
    private int amount;
    private WNBankAccount account;

    public WNBankThread(String type, WNBankAccount account, int amount) {
        this.type = type;
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (type.equals("DEPOSIT")) {
            
            synchronized (account) { // the account is the locked object
                account.deposit(amount);
                account.notifyAll();
            }
            
        } else if (type.equals("BONUS")) {
            
            synchronized (account) { // acquire the lock on the account
              
                while (account.getBalance() < amount) { // we need balance to be >= to apply the bonus
                    // so while this is NOT true, we'll wait
                    try {
                        account.wait(); // releases the lock
                    } catch (InterruptedException ex) {}
                }
                account.applyBonus();
            }
        }

    }

}
