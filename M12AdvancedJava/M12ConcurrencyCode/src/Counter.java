import java.util.concurrent.locks.*;

public class Counter {

    private int c;

    public Counter() {
        c = 0;
    }

    public void increment() { // add synchronized to avoid race condition!
        c++;
    }

    public void decrement() { // add synchronized to avoid race condition!
        c--;
    }

    public String toString() {
        return Integer.toString(c);
    }

}
