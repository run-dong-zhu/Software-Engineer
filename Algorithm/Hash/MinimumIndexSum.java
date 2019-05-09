package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description LeetCode 599, level: Easy
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSum {

    public String[] solution(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        int least = Integer.MAX_VALUE;
        
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                if(map.get(list2[i]) + i <= least) {
                    if(map.get(list2[i]) + i < least) {
                        result.clear();
                    }
                    least = map.get(list2[i]) + i;
                    result.add(list2[i]);
                }
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    public static void main(String[] args) {
        MinimumIndexSum mis = new MinimumIndexSum();
        
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        
        for(String str : mis.solution(list1, list2)) {
            System.out.println(str);
        }
    }

}
