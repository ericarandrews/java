import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class AtomicCounter {

    private AtomicInteger counter;

    public AtomicCounter() {
        counter = new AtomicInteger(0);
    }

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public String toString() {
        return Integer.toString(counter.get());
    }

}
