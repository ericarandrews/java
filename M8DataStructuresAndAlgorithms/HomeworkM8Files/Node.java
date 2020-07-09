public class Node<T> {
	
	public T data;
	public Node<T> next;

	public Node(T dataPortion) {
		data = dataPortion;
		next = null;
	} 

	public Node(T dataPortion, Node<T> nextNode) {
		data = dataPortion;
		next = nextNode;
	} 

	public T getData() {
		return data;
	}

	public void setData(T newData) {
		data = newData;
	} 

	public Node<T> getNextNode() {
		return next;
	} 

	public void setNextNode(Node<T> nextNode) {
		next = nextNode;
	} 
} 