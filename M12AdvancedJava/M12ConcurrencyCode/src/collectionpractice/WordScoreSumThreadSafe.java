package collectionpractice;

import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class WordScoreSumThreadSafe implements Runnable {
    
    private Map<Character, Long> map;
    private String word;
    
    public WordScoreSumThreadSafe(Map<Character, Long> map, String word) {
        this.map = map;
        this.word = word;
    }
    
    @Override
    public void run() {
        // not-thread safe:   
        /*
        Long current = map.get(word.charAt(0));
        if(current==null) { 
            map.put(word.charAt(0), 0L); 
        }
        */
        // thread-safe:
        map.putIfAbsent(word.charAt(0), 0L);

        
        long score = wordScore(word);
        
        // not thread safe:     
        /*
        long currentScore = map.get(word.charAt(0)).longValue();
         currentScore += score;
         map.replace(word.charAt(0), currentScore);
        */
        // not thread safe, even though one line of code!
        //map.replace(word.charAt(0), map.get(word.charAt(0))+score);
        
        // compute takes two parameters: key and BiFunction<K,V>
        // the key is the first character
        // BiFunction takes two parameters (key and value) and returns a value
       
        map.compute(word.charAt(0), // first parameter to compute method
                (wordChar, currentScore) -> { // second parameter to compute method- a lambda
                    // these are the two parameters to the BiFunction
                    //  a key (character) and a value (Long)
                   
                    currentScore += score; 
                   
                    return currentScore; // return the value
                }
                
                );
      
        
    }

    public static int wordScore(String s) {
        char[] letters = s.toLowerCase().toCharArray();
        int total = 0;
        for (char c : letters) {
            total += charToScore(c);
        }
        return total;
    }

    public static int charToScore(char c) {
        switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'n':
        case 'r':
        case 't':
        case 'l':
        case 's':
            return 1;
        case 'g':
        case 'd':
            return 2;
        case 'b':
        case 'c':
        case 'm':
        case 'p':
            return 3;
        case 'f':
        case 'h':
        case 'v':
        case 'w':
        case 'y':
            return 4;
        case 'k':
            return 5;
        case 'j':
        case 'x':
            return 8;
        case 'q':
        case 'z':
            return 10;
        default:
            return -1;
        }
    }
}
