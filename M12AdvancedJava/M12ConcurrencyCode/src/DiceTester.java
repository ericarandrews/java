
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Stream;

public class DiceTester {

	public static void main(String[] args) throws InterruptedException {

	    final int numPlayers = 10000;
	    int[] playersDoublesCount = new int[numPlayers];
	    final int numRolls = 1000;
		
		// low-level threading- one thread manually created for each player
		Instant start = Instant.now();
		Thread[] diceThreads = new Thread[numPlayers];
		
		for(int i=0; i<diceThreads.length; i++) {
		    final int playerNum = i;
			diceThreads[playerNum] = new Thread( () -> { // lambda is Runnable
				Random generator = new Random();
				int doublesCount = 0;
				for(int j=0; j<numRolls; j++) {
					int die1 = generator.nextInt(6);
					int die2 = generator.nextInt(6);
					if(die1==die2) doublesCount++;
				}
				playersDoublesCount[playerNum] = doublesCount;
				
			});
		}
		
		for(Thread diceRoller : diceThreads) {
			diceRoller.start();
		}
		System.out.println("There are " + Thread.activeCount() + " threads running");

		for(Thread diceRoller : diceThreads) {
			diceRoller.join();
		}
		
		double averageDoubles = Arrays.stream(playersDoublesCount).average().getAsDouble();
		int min = Arrays.stream(playersDoublesCount).min().getAsInt();
		int max = Arrays.stream(playersDoublesCount).max().getAsInt();
		double doublePercentage = averageDoubles / numRolls;
		System.out.println("Players rolled between " + min + " and " + max + " doubles, " + 
		        "with an average of " + averageDoubles + " (" +
		        NumberFormat.getPercentInstance().format(doublePercentage) + ")" +
		        " doubles rolled by each player.");
		long duration = Duration.between(start, Instant.now()).toMillis();
		System.out.println("Time for low-level threading: " + duration);	

		
		// use executor for higher level threading and thread pool
		
		int[] playersDoublesCountE = new int[numPlayers];
		start = Instant.now();
		int numThreadsInPool = 10;
		//ExecutorService executor = Executors.newFixedThreadPool(numThreadsInPool);
		ExecutorService executor = Executors.newCachedThreadPool();
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i=0; i<numPlayers; i++) {
            final int playerNum = i;
            
			executor.execute( () -> { // lambda is the Runnable code
				Random generator = new Random();
				int doublesCount = 0;
				for(int j=0; j<numRolls; j++) {
					int die1 = generator.nextInt(6);
					int die2 = generator.nextInt(6);
					if(die1==die2) doublesCount++;
				}
				playersDoublesCountE[playerNum] = doublesCount;
			});
		}
				
		System.out.println("There are " + Thread.activeCount() + " threads running");
		executor.shutdown();

		while(!executor.isTerminated()) {} // can also use awaitTerminations
		
		averageDoubles = Arrays.stream(playersDoublesCountE).average().getAsDouble();
        min = Arrays.stream(playersDoublesCountE).min().getAsInt();
        max = Arrays.stream(playersDoublesCountE).max().getAsInt();
        doublePercentage = averageDoubles / numRolls;
        System.out.println("Players rolled between " + min + " and " + max + " doubles, " + 
                "with an average of " + averageDoubles + " (" +
                NumberFormat.getPercentInstance().format(doublePercentage) + ")" +
                " doubles rolled by each player.");
		
		duration = Duration.between(start, Instant.now()).toMillis();
		System.out.println("Time for executor threading: " + duration);	
	
		
		
	
	}

}
