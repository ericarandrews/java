import java.util.Scanner;

public class ListInterfaceRecursionExample {

	public static void main(String[] args) {
		ListInterface<Integer> list = new AList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(4);
		System.out.println(list.contains(1));
		System.out.println(list.contains(4));
		System.out.println(list.contains(2));
		System.out.println(list.contains(5));

	}

	public static boolean listContains(ListInterface list, Object item) {
		return listContainsHelper(list, item, 1, list.getLength());
	}

	private static boolean listContainsHelper(ListInterface list, Object item,
			int start, int end) {
		if (start <= end) { // recursive case
			Object currentItem = list.getEntry(start);
			if (currentItem.equals(item)) {
				return true;
			} else {
				return listContainsHelper(list, item, start + 1, end);
			}

		} else { // base case: start > end
			return false;
		}
	}


}
