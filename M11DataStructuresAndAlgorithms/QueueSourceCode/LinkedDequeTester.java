public class LinkedDequeTester {

	public static void main(String[] args) {
		// *** to use, temporarily make the firstNode and lastNode in LinkedDeque public 
		// (note I also made parts of the DLNode class public)
		LinkedDeque<String> wordDeque = new LinkedDeque<String>();
		
		printDeque(wordDeque);
		wordDeque.addToBack("amps");
		printDeque(wordDeque);
		wordDeque.addToBack("bank");
		printDeque(wordDeque);
		wordDeque.addToFront("card");
		printDeque(wordDeque);
		wordDeque.addToFront("door");
		printDeque(wordDeque);
		wordDeque.removeFront();
		printDeque(wordDeque);
		wordDeque.removeBack();
		printDeque(wordDeque);
		wordDeque.removeFront();
		printDeque(wordDeque);
		wordDeque.removeBack();
		printDeque(wordDeque);
	}

	private static void printDeque(LinkedDeque deque) {
		
		LinkedDeque.DLNode currentFirst = deque.firstNode;
		LinkedDeque.DLNode currentLast = deque.lastNode;
		if(currentFirst==null) {
			System.out.println("Front: null \tBack: null");
		} else if(currentFirst==currentLast) {
			System.out.println("Front: " + deque.firstNode.data + "\tBack: " + deque.lastNode.data+"\t"+deque.lastNode.data);
		} else {
			System.out.print("Front: " + deque.firstNode.data + "\tBack: " + deque.lastNode.data+"\t");
			System.out.print(currentFirst.data + " <--> ");
			currentFirst = currentFirst.next;
			while(currentFirst.next != null) {
				System.out.print(currentFirst.data + " <--> ");
				currentFirst = currentFirst.next;
				
			}
			System.out.println(currentFirst.data);
		}
	}
	
}