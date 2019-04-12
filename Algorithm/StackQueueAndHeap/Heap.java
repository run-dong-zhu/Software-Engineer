package stackandqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {

    
    
    public static void main(String[] args) {
        // Create heap using PriorQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                    
                });
        
        for(int i = 0; i < 5; i++) {
            int val = (int)(Math.random() * 100);
            System.out.print(val + " ");
            minHeap.add(val);
            maxHeap.add(val);
        }
        
        System.out.println();
        
        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        
        System.out.println();
        
        while(!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }

}
