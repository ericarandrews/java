
public abstract class Person implements HRProcessor {
    
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //public abstract void review();
    // if included, this would force all child classes
    // to implement the review method- they could no longer
    // use the default version
    
    @Override
    public String toString() {
        return name;
    }

}
