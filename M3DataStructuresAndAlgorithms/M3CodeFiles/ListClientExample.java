import java.util.*;

public class ListClientExample {

	public static void main(String[] args) {

		//ListInterface<Integer> scoreList = new AList<>();
		List<Integer> scoreList = new ArrayList<>();
		removeLowestScore(scoreList); // testing with an empty list

		scoreList.add(75);
		scoreList.add(90);
		scoreList.add(100);
		scoreList.add(50);
		scoreList.add(88);

		System.out.println(Arrays.toString(scoreList.toArray()));
		removeLowestScore(scoreList);
		System.out.println(Arrays.toString(scoreList.toArray()));
		
		ListInterface<Integer> numberList = new AList<>();
		numberList.add(10);
		numberList.add(-10);
		numberList.add(4);
		numberList.add(0);
		numberList.add(-13);
		numberList.add(20);
		numberList.add(-10);
		System.out.println(countNegatives(numberList));
		
		List<Integer> numberList2 = new ArrayList<>();
		numberList2.add(10);
		numberList2.add(-10);
		numberList2.add(4);
		numberList2.add(0);
		numberList2.add(-13);
		numberList2.add(20);
		numberList2.add(-10);
		System.out.println(countNegatives(numberList2));

	}

	// removes the first occurrence of the lowest value
	public static void removeLowestScore(ListInterface<Integer> scoreList) {
		if (!scoreList.isEmpty()) {
			int lowestScore = scoreList.getEntry(1);
			int lowestScorePosition = 1;

			// first element is in position 1
			// last element is in position at getLength (so need to loop up to AND INCLUDING position getLength)
			for (int i = 2; i <= scoreList.getLength(); i++) {
				int currentScore = scoreList.getEntry(i);
				if (currentScore < lowestScore) {
					lowestScore = currentScore;
					lowestScorePosition = i;
				}
			}
			

			scoreList.remove(lowestScorePosition);
		} else {
			System.out.println("Cannot remove a score from an empty list.");
		}
	}
	
	public static void removeLowestScore(List<Integer> scoreList) {
		if(!scoreList.isEmpty()) {
			int lowestScore = scoreList.get(0);
			
			// traditional for-loop
			/* 
			for(int i=1; i<scoreList.size(); i++) {
				int currentScore = scoreList.get(i);
				if(currentScore < lowestScore) {
					lowestScore = currentScore;
				}
			}
			*/
			
			// enhanched for-loop or for-each loop
			// this is the recommended loop to use when possible
			// (if you need access to the index number, don't use this!)
			for(int score : scoreList) {
				if(score < lowestScore) {
					lowestScore = score;
				}
			}
			
			scoreList.remove(Integer.valueOf(lowestScore));
			
		} else {
			System.out.println("Cannot remove a score from an empty list.");
		}
	}

	
	public static int countNegatives(ListInterface<Integer> numberList) {
		int count = 0;
		
		for(int i=1; i<=numberList.getLength(); i++) {
			if(numberList.getEntry(i) < 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int countNegatives(List<Integer> numberList) {
		int count = 0;
		
		for(int number : numberList) {
			if(number<0) {
				count++;
			}
		}
		/*
		for(int i=0; i<numberList.size(); i++) {
			if(numberList.get(i)<0) {
				count++;
			}
		}
		*/
		return count;
		
	}
	
}
