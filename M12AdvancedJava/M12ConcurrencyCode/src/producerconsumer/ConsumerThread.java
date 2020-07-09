package producerconsumer;

import java.util.Random;

public class ConsumerThread implements Runnable {

    private NumberBox numberBox;

    public ConsumerThread(NumberBox numberBox) {
        this.numberBox = numberBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (numberBox) {
                while (!numberBox.isFilled()) {
                    try {
                        System.out.println("Consumer\twaiting to get a number\ttrial " + i);
                        numberBox.wait();
                    } catch (InterruptedException ex) {}
                }
                int number = numberBox.getNumberFromBox();
                System.out.println("Consumer\tretreiving " + number + " for processing");
                numberBox.notify();
            }
            try {
                System.out.println("Consumer \tsleeping");
                Thread.sleep((new Random()).nextInt(5000));
                System.out.println("Consumer \tawake");
            } catch (InterruptedException ex) { }
        }

    }

}
