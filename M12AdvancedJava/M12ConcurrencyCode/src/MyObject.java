
public class MyObject {
	
	private Object obj1, obj2;
	
	public MyObject() {
		obj1 = new Object();
		obj2 = new Object();
	}
	
	public void methodA() {
		synchronized(obj1) {
			System.out.println("in method A with obj1 locked");
		
			synchronized(obj2) {
				System.out.println("in method A with obj2 locked");
			}
		}
	}
	
	public void methodB() {
		synchronized(obj2) {
			System.out.println("in method B with obj2 locked");
		
			synchronized(obj1) {
				System.out.println("in method B with obj1 locked");
			}
		}
	}
	


}
