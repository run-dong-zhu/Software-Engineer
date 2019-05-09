package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for(int key : map.keySet()) {
            heap.add(key);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        while(!heap.isEmpty()) {
            result.add(heap.poll());
        }
        
        Collections.reverse(result);
        
        return result;
    }
    
    public static void main(String[] args) {
        KFrequentElements kfe = new KFrequentElements();
        
        int[] nums = {1, 1, 1, 2, 2, 3};
        kfe.topKFrequent(nums, 2);
    }
}
