
public class Trio<T> {

	private T item1, item2, item3;
	
	public Trio(T item1, T item2, T item3){
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
//	Getters
	public T getItem1() {
		return item1;
	}
	public T getItem2() {
		return item2;
	}
	public T getItem3() {
		return item3;
	}
	
//	Setters
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public void setItem2(T item2) {
		this.item2 = item2;
	}
	public void setItem3(T item3) {
		this.item3 = item3;
	}
	
	
	@Override
	public String toString() {
		return item1.toString() + "\t" + item2.toString() + "\t" + item3.toString();
	}
	
    public void reset(Object item){
    	item = item1;
    	item = item2;
    	item = item3;
    }
	
    public int count(int count){
    	if(item1 != null){count++;};
    	if(item2 != null){count++;};
    	if(item3 != null){count++;};
    	return count;
    }
    public String count(String string){
    	int count = 0;
    	if(item1 != null){count++;};
    	if(item2 != null){count++;};
    	if(item3 != null){count++;};
    	string = String.valueOf(count);
    	return string;
    }
    public boolean hasDuplicates(){

    	if(item1 instanceof Integer && item2 instanceof Integer){return true;}
    	if(item2 instanceof Integer && item3 instanceof Integer){return true;}
    	if(item3 instanceof Integer && item1 instanceof Integer){return true;}
    	
    	if(item1 instanceof String && item2 instanceof String){return true;}
    	if(item2 instanceof String && item3 instanceof String){return true;}
    	if(item3 instanceof String && item1 instanceof String){return true;}
    	return false;
    }
    
	public boolean sameItems(Object trio) {
		
		Trio x = (Trio) trio;
	
		//Objects equal
		if(trio.equals(this)){
		return true;
		}	
		//Objects being compared are integers
		else if(item1 instanceof Integer && item2 instanceof Integer && item3 instanceof Integer){
		//Objects are considered logically equivalent	
		if(x.item1 instanceof Integer && x.item2 instanceof Integer && x.item3 instanceof Integer){
		return true;
		}		
		}
		//Object being compared has strings
		else if(item1 instanceof String && item2 instanceof String && item3 instanceof String){
		//Objects are considered logically equivalent	
		if(x.item1 instanceof String && x.item2 instanceof String && x.item3 instanceof String){
		return true;
		}	
		}
		//Object being compared has integers and strings
		else if((item1 instanceof Integer && item2 instanceof String && item3 instanceof String) ||
				(item1 instanceof String && item2 instanceof Integer && item3 instanceof String) ||
				(item1 instanceof String && item2 instanceof String && item3 instanceof Integer) ||
				
				(item1 instanceof Integer && item2 instanceof Integer && item3 instanceof String) ||
				(item1 instanceof String && item2 instanceof Integer && item3 instanceof Integer) ||
				(item1 instanceof Integer && item2 instanceof String && item3 instanceof Integer)){
		//Objects are considered logically equivalent	
		if((x.item1 instanceof Integer && x.item2 instanceof String && x.item3 instanceof String) ||
		   (x.item1 instanceof String && x.item2 instanceof Integer && x.item3 instanceof String) ||
		   (x.item1 instanceof String && x.item2 instanceof String && x.item3 instanceof Integer) ||
			
			(x.item1 instanceof Integer && x.item2 instanceof Integer && x.item3 instanceof String) ||
			(x.item1 instanceof String && x.item2 instanceof Integer && x.item3 instanceof Integer) ||
			(x.item1 instanceof Integer && x.item2 instanceof String && x.item3 instanceof Integer)){
		return true;
		}
		}
		return false;	
	}
}
