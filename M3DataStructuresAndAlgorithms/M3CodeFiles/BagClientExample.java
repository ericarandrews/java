import java.util.*;

public class BagClientExample {

	public static void main(String[] args) {

		BagInterface<Integer> quizScoreBag = new ArrayBag<Integer>();
		quizScoreBag.add(50);
		quizScoreBag.add(60);
		quizScoreBag.add(70);
		quizScoreBag.add(80);
		quizScoreBag.add(90);
		quizScoreBag.add(10);
		
		System.out.println(Arrays.toString(quizScoreBag.toArray()));
		removeLowestScore(quizScoreBag);
		System.out.println(Arrays.toString(quizScoreBag.toArray()));
		
		BagInterface<String> wordBag = new ArrayBag<String>();
		wordBag.add("username1");
		wordBag.add("email1@mail.com");
		wordBag.add("username2");
		wordBag.add("username3");
		wordBag.add("email2@mail.com");
		wordBag.add("email3@mail.com");
		printStringsWithCharacter(wordBag, '@');
		System.out.println(Arrays.toString(wordBag.toArray()));
		
		
	}

	public static void removeLowestScore(BagInterface<Integer> quizScoreBag) {
		BagInterface<Integer> tempBag = new ArrayBag<Integer>();

		if (!quizScoreBag.isEmpty()) {
			Integer lowestScore = quizScoreBag.remove();
			tempBag.add(lowestScore);

			while (!quizScoreBag.isEmpty()) {
				Integer currentScore = quizScoreBag.remove();
				tempBag.add(currentScore);

				if (currentScore < lowestScore) {
					lowestScore = currentScore;
				}
			}
			// I have found the lowest score
			// quizScoreBag is empty!
			// tempBag holds all of the scores

			while (!tempBag.isEmpty()) {
				Integer score = tempBag.remove();
				quizScoreBag.add(score);
			}
			quizScoreBag.remove(lowestScore);
		}

	}
	
	public static void printStringsWithCharacter(BagInterface<String> wordBag, char targetChar) {
		BagInterface<String> tempBag = new ArrayBag<>();
		
		while(!wordBag.isEmpty()) {
			String word = wordBag.remove();
			
			if(word.indexOf(targetChar) >= 0) {
				System.out.println(word);
			}
			
			tempBag.add(word);
		}
		
		while(!tempBag.isEmpty()) {
			wordBag.add(tempBag.remove());
		}
	}
	

}
