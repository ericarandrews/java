package collectionpractice;
import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollectionsTest {
	

	public static void main(String[] args) throws Exception {
		
	    // List<Integer> numList = new ArrayList<>(); // NOT THREAD SAFE! NOOO!
		List<Integer> numList = Collections.synchronizedList(new ArrayList<>());

		for(int i=0; i<1000; i++) {
			Thread threadAdd = new Thread(new ListAdder(numList, i));
			threadAdd.start();
		}

		while(Thread.activeCount()>1) {} // wait for all threads to finish
		
		System.out.println("List size should be 1000: " + numList.size());

		
		int size = numList.size();
		for(int i=0; i<size; i++) {
			Thread threadRemove = new Thread(new ListRemover(numList));
			threadRemove.start();
		}
		
		while(Thread.activeCount()>1) {}
		
	    System.out.println("List size should be 0: " + numList.size());
	
	

	}

		
}
