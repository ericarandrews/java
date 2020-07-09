
public class DeadlockThread extends Thread {

	private MyObject obj;
	private boolean callA;
	
	public DeadlockThread(MyObject obj, boolean callA) {
		this.obj = obj;
		this.callA = callA;
	}
	
	@Override
	public void run() {
		if(callA) {
			obj.methodA();
		} else {
			obj.methodB();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyObject obj = new MyObject();
		Thread threadA = new DeadlockThread(obj, true);
		Thread threadB = new DeadlockThread(obj, false);
		
		threadA.start();
		threadB.start();
		
		threadA.join();
		threadB.join();
		
		System.out.println("done");
	}
}
