public abstract class Item implements Comparable<Item> {
    
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name: " + name ;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if(obj instanceof Item) {
	        return name.equals(((Item)obj).getName());
	    } else {
	        return false;
	    }
	}
	
	@Override
	public int compareTo(Item otherItem) {
			return name.compareTo(otherItem.name);
	}
	

	
	
	
	
	
	
	
	
	
}
