
public interface HRProcessor {
 
    // these methods are automatically are public and abstract
    void pay(); 
    void benefits();
    
    // this method is still public
    default void review() {
        System.out.println("Processing review");
    }
    

}
