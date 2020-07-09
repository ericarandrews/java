package collectionpractice;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

public class ConcurrentMapTestingScrabble {

	public static void main(String[] args) throws Exception {
		List<String> scrabbleWords = 
				Files.readAllLines(Paths.get("words.txt"), Charset.forName("ISO-8859-1")); 
		
		
		// single-threaded version
		System.out.println("***Number of words that start with that letter (from stream):");
		Map<Character, Long> startLetterCountFromStreams = scrabbleWords.stream()
				.collect(Collectors.groupingBy(
							word -> word.charAt(0), // key- Character
							Collectors.counting() )); // value- count
		System.out.println(startLetterCountFromStreams);
		
		// incorrect threaded version
		/*
		Map<Character, Long> startLetterCountThreaded = new ConcurrentHashMap<>(); // thread safe! 
		//Map<Character, Long> startLetterCountThreaded = new HashMap<>(); // not thread safe!!
		for(String word : scrabbleWords) {
			Thread thread = new Thread(new LetterStartThread(startLetterCountThreaded, word));
			thread.start();
		}

		while(Thread.activeCount()>1) {} // wait for the threads to finish
		
		System.out.println("***Number of words that start with that letter (from thread):");
		System.out.println(startLetterCountThreaded);
		*/
		
		/*
		// correct threaded version
		Map<Character, LongAdder> startLetterCountThreadedSafe = new ConcurrentHashMap<>(); 
        for(String word : scrabbleWords) {
            Thread thread = new Thread(new LetterStartThreadSafe(startLetterCountThreadedSafe, word));
            thread.start();
        }

        while(Thread.activeCount()>1) {} // wait for the threads to finish
        
        System.out.println("***Number of words that start with that letter (from safe thread):");
        System.out.println(startLetterCountThreadedSafe);
		*/
       
       
		// non-threaded version
        System.out.println("***Total score of words that start with that letter (from stream):");
		Map<Character, Long> scoreTotals = scrabbleWords.stream()
				.collect(Collectors.groupingBy(
							word -> word.charAt(0), // lambda to define the key: map from String to Character
							Collectors.summingLong(word->WordScoreSumThreadSafe.wordScore(word)) // calculate the value
							// summingInt takes a lambda from String to int
						));
		System.out.println(scoreTotals);
		
		// correct threaded version
		Map<Character, Long> scoreTotalsSafe = new ConcurrentHashMap<>();
        for(String word : scrabbleWords) {
			Thread thread = new Thread(new WordScoreSumThreadSafe(scoreTotalsSafe, word));
			thread.start();
		}
		while(Thread.activeCount()>1) {}
		
        System.out.println("***Total score of words that start with that letter (from safe stream):");
		System.out.println(scoreTotalsSafe);
		

	
	}


	
	
	
	
	
	
	
}
