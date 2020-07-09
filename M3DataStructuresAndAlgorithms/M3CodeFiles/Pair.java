
public class Pair<T extends Comparable<? super T>>  implements Comparable<Pair<T>>{
	
	private T item1, item2;
	
	public Pair(T item1, T item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public T getItem1() {
		return item1;
	}
	public T getItem2() {
		return item2;
	}
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public void setItem2(T item2) {
		this.item2 = item2;
	}
	
	@Override
	public String toString() {
		return "[" + item1.toString() + ", " + item2.toString() + "]";
	}
	
	public boolean sameItems() {
		return item1.equals(item2);
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Pair<?>) {
			Pair<?> otherPair = (Pair<?>) obj;
			return item1.equals(otherPair.item1) && item2.equals(otherPair.item2);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Pair<T> otherPair) {
		if(this.item1.compareTo(otherPair.item1) < 0) { // this item1 is smaller than the other item1
			return -1; // any negative number
		} else if(this.item1.compareTo(otherPair.item1) > 0) { // this item1 is greater than the other item1
			return 1; // any positive number
		} else { // this.item1.compareTo(otherPair.item1) == 0
			if(this.item2.compareTo(otherPair.item2) < 0) { // this item2 is smaller than the other item2
				return -1; // any negative number
			} else if(this.item2.compareTo(otherPair.item2) > 0) { // this item2 is greater than the other item2
				return 1; // any positive number
			} else { // this.item2.compareTo(otherPair.item2) == 0
				return 0;
			}
		}
	}
	
	

}
