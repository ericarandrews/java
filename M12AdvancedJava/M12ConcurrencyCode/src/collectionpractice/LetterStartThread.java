package collectionpractice;

import java.util.Map;

public class LetterStartThread implements Runnable {

    private Map<Character, Long> map;
    private String word;
    
    public LetterStartThread(Map<Character, Long> map, String word) {
        this.map = map;
        this.word = word;
    }
    
    @Override
    public void run() {
        Character startingLetter = word.charAt(0);
        Long count = map.get(startingLetter);
        
        if(count!=null) {
            map.put(startingLetter, count+1);
        } else {
            map.put(startingLetter, 1L);
        }
    }
}
