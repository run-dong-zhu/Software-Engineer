package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        
        if(words.length < 1) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()) : e1.getValue() - e2.getValue());
        
        for(String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        while(!heap.isEmpty()) {
            result.add(0, heap.poll().getKey());
        }
        
        Collections.reverse(result);
        
        return result;
    }
    
    public static void main(String[] args) {
        TopKFrequentWords tkfw = new TopKFrequentWords();
        
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        System.out.println(tkfw.topKFrequent(words, 2));
    }

}
