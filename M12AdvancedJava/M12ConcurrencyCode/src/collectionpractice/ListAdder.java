package collectionpractice;

import java.util.*;

public class ListAdder implements Runnable {

    private List<Integer> numList;
    private int num;

    public ListAdder(List<Integer> numList, int num) {
        this.numList = numList;
        this.num = num;
    }

    @Override
    public void run() {

        int position = 0;
        
        synchronized(numList) {
            if (numList.size() > 0) {
                position = (new Random()).nextInt(numList.size());
            }
            numList.add(position, num);
        }

    }

}
