package recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @description LeetCode 90, level: Medium
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Subset2 {
    
    private static void generator(int count, int[] num, List<Integer> item, List<List<Integer>> result, Set<List<Integer>> itemSet) {
        if(count >= num.length) {
            return;
        }
        
        item.add(num[count]);
        if(!itemSet.contains(item)) {
            itemSet.add(item);
            result.add(new ArrayList<>(item));
        }
        
        generator(count + 1, num, item, result, itemSet);
        item.remove(item.size() - 1);
        generator(count + 1, num, item, result, itemSet);
    }
    
    public static List<List<Integer>> solution(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        result.add(item);
        
        Set<List<Integer>> itemSet = new HashSet<>();
        
        generator(0, num, item, result, itemSet);
        
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 2};
        List<List<Integer>> result = solution(num);
        
        for(int i = 0; i < result.size(); i++) {
            List<Integer> item = result.get(i);
            for(int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + " ");
            }
            System.out.println();
        }
    }

}
