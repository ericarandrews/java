package producerconsumer;

public class NumberBox {

    private int number;
    private boolean boxFilled;

    public NumberBox() {
        boxFilled = false;
    }

    public synchronized int getNumberFromBox() {
        boxFilled = false;
        return number;
    }

    public synchronized void putNumberInBox(int number) {
        this.number = number;
        boxFilled = true;
    }

    public synchronized boolean isFilled() {
        return boxFilled;
    }

    public String toString() {
        return Integer.toString(number);
    }
}
