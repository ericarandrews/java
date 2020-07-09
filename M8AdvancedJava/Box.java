
public class Box<T extends Comparable<? super T>> {
    
    private T item;
    
    public Box(T item) {
        this.item = item;
    }
    public Box() {
        this(null);
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Box [item=" + item + "]";
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Box<?>) {
            Box<?> otherBox = (Box<?>) obj;
            return item.equals(otherBox.item);
        } else {
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   

}
