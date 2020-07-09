
public abstract class Clothing extends Item implements Comparable<Item> {


	public static enum Size {SMALL, MEDIUM, LARGE};
	
	private Size size;
	
	public Clothing(String name, Size size) {
		super(name);
		this.size = size;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Size: " + size;
	}
	
	
	@Override
	public int compareTo(Item item) {
	    if(item instanceof Clothing) {
	        Clothing otherClothing = (Clothing) item;
	        
            int parentCompare = super.compareTo(item);
            
            if(parentCompare==0) {
                return size.compareTo(otherClothing.size);
            } else {
                return parentCompare;
            }
	        
        } else {
            return super.compareTo(item); // choice 1: use the parent version to compare the "parent parts" of the items only
            //throw new IllegalArgumentException("Clothing item required"); // choice 2: throw an exception
        }
	   
	}

	
	
	
	
}
