
public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashTableLocation(int voterID) {
		// YOUR CODE HERE
		return 0;
	}

	public boolean addVoter(Voter voterToAdd) {
		// YOUR CODE HERE
		return false;
	}

	public Voter getVoter(int voterID) {
		// YOUR CODE HERE
		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
