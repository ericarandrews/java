package collectionpractice;

import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class LetterStartThreadSafe implements Runnable {
    private Map<Character, LongAdder> map;
    private String word;
    
    public LetterStartThreadSafe(Map<Character, LongAdder> map, String word) {
        this.map = map;
        this.word = word;
    }
    
    @Override
    public void run() {
        map.putIfAbsent(word.charAt(0), new LongAdder()); // this method is atomic!
        map.get(word.charAt(0)).increment(); // this method also atomic! operations on LongAdder are also atomic!
    }
}