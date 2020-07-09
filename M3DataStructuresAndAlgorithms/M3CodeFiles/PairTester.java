import java.util.*;

public class PairTester {

	public static void main(String[] args) {
		Pair<Integer> numberPair1 = new Pair<Integer>(3,4);
		Pair<Integer> numberPair2 = new Pair<Integer>(3,4);
		Pair<Integer> numberPair3 = new Pair<Integer>(4,1);
		Pair<Integer> numberPair4 = new Pair<Integer>(1,3);
		Pair<Integer> numberPair5 = new Pair<Integer>(3,1);
		Pair<Integer> numberPair6 = new Pair<Integer>(3,6);
		
		System.out.println("pair1 compared to pair2: " + numberPair1.compareTo(numberPair2));
		System.out.println("pair1 equal to pair2: " + numberPair1.equals(numberPair2));
		System.out.println("pair1 compared to pair3: " + numberPair1.compareTo(numberPair3));
		System.out.println("pair1 compared to pair4: " + numberPair1.compareTo(numberPair4));
		System.out.println("pair1 compared to pair4: " + numberPair1.compareTo(numberPair5));
		System.out.println("pair1 compared to pair4: " + numberPair1.compareTo(numberPair6));		
	
		List<Pair<Integer>> numberPairList = new ArrayList<Pair<Integer>>();
		numberPairList.add(numberPair1);
		numberPairList.add(numberPair2);
		numberPairList.add(numberPair3);
		numberPairList.add(numberPair4);
		numberPairList.add(numberPair5);
		numberPairList.add(numberPair6);
		
		System.out.println(numberPairList);
		Collections.sort(numberPairList);
		System.out.println(numberPairList);
		
		

	}

}
