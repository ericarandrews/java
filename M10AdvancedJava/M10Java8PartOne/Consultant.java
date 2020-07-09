
public class Consultant extends Person {
   
    public Consultant(String name) {
        super(name);
    }
    
    @Override
    public void pay() {
        System.out.println("Paying " + getName() + " a consultant rate");
    }
      
    @Override
    public void benefits() {
        System.out.println("Consultants do not get benefits.");
    }
    
    // the review method is not included at all
    // so the default version from HRProcessor is used
    

  
    @Override
    public String toString() {
        return super.toString() + " (Consultant))";
    }


}
