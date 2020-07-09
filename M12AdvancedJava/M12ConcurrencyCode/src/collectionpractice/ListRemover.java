package collectionpractice;

import java.util.List;
import java.util.*;

public class ListRemover implements Runnable {

    private List<Integer> numList;

    public ListRemover(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    public void run() {

        Random generator = new Random();
        
        synchronized(numList) {
            int position = generator.nextInt(numList.size());
        
            // try{ Thread.sleep(5); } catch(InterruptedException ex) {}
        
            Integer element = numList.get(position);
            numList.remove(element);
        }

    }

}
