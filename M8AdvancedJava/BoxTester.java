
public class BoxTester {

    public static void main(String[] args) {
        Box<String> wordBox1 = new Box<>("hello");
        Box<String> wordBox2 = new Box<>("hello");
        System.out.println(wordBox1.equals(wordBox2));
        
        Box<Integer> numberBox1 = new Box<>(1);
        System.out.println(wordBox1.equals(numberBox1));
        
        //Box<Student> studentBox = new Box<>(); // COMPILER ERROR- Student does implement Comparable!
        Box<Item> itemBox = new Box<>(); // allowed because Item implements Comparable<Item>
        Box<Clothing> clothingBox = new Box<>(); // originally not allowed because 
        // Clothing implements Comparable<Item> not Comparable<Clothing>
        
        Box<Shirt> shirtBox = new Box<>();
        Box<Book> bookBox = new Box<>();

    }

}
