public class Node<T> {
	
	// public for testing purposes only!!
	public T data; // element in the list
	public Node next; // link to next node

	public Node(T dataPortion) {
		this(dataPortion, null);
	} 

	public Node(T dataPortion, Node nextNode) {
		data = dataPortion;
		next = nextNode;
	} 

	public T getData() {
		return data;
	} 

	public void setData(T newData) {
		data = newData;
	} 
	
	public Node getNextNode() {
		return next;
	} 

	public void setNextNode(Node nextNode) {
		next = nextNode;
	} 
} 