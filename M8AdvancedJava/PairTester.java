
public class PairTester {

    public static void main(String[] args) {
        Pair<Integer> numberPair1 = new Pair<>(3, 4);    
        Pair<Integer> numberPair2 = new Pair<Integer>(5, 6);
        Pair<String> wordPair1 = new Pair<String>("apple", "banana");
        
        int num1 = numberPair1.getFirst();
        String word = wordPair1.getSecond();
        
        //numberPair1.setFirst("hello"); // COMPILER ERROR
        //wordPair1.setSecond(Integer.valueOf(4)); // COMPILER ERROR
        
        PairRaw numberPair3 = new PairRaw(3, 4);
        PairRaw mixedPair1 = new PairRaw(5, "apple");
        
        // int num2 = numberPair3.getFirst(); // COMPILER ERROR
        

    }

}
