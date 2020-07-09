package producerconsumer;

import java.util.Random;

public class ProducerThread implements Runnable {

    private NumberBox numberBox;

    public ProducerThread(NumberBox numberBox) {
        this.numberBox = numberBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (numberBox) {
                while (numberBox.isFilled()) {
                    try {
                        System.out.println("Producer\twaiting until a number is needed\ttrial " + i);
                        numberBox.wait();
                    } catch (InterruptedException ex) { }
                }
                int number = (new Random()).nextInt(100);
                numberBox.putNumberInBox(number);
                System.out.println("Producer\tadding " + number + " to the box");
                numberBox.notify();
            }
            try {
                System.out.println("Producer \tsleeping");
                Thread.sleep((new Random()).nextInt(5000));
                System.out.println("Producer \tawake");
            } catch (InterruptedException ex) { }
        }

    }

}
