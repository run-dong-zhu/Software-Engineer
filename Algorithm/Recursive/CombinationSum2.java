package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @description LeetCode 40, level: Medium
 * 
 * https://leetcode.com/problems/combination-sum-ii/
 *
 */
public class CombinationSum2 {
    
    public static void printResult(List<List<Integer>> result) {
        for(int i = 0; i < result.size(); i++) {
            List<Integer> item = result.get(i);
            for(int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public static void generator(int index, int target, int sum, int[] candidates,
            List<Integer> item, List<List<Integer>> result, Set<List<Integer>> itemSet) {
        if(index >= candidates.length || sum > target) {
            return;
        }
        sum += candidates[index];
        item.add(candidates[index]);
        if(target == sum && !itemSet.contains(item)) {
            result.add(new ArrayList<>(item));
            //itemSet.add(new ArrayList<>(item));
            itemSet.add(item);
        }
        
        generator(index + 1, target, sum, candidates, item, result, itemSet);
        sum -= candidates[index];
        item.remove(item.size() - 1);
        generator(index + 1, target, sum, candidates, item, result, itemSet);
    }
    
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Set<List<Integer>> itemSet = new HashSet<>();
        
        Arrays.sort(candidates);
        
        generator(0, target, 0, candidates, item, result, itemSet);
        
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        
        List<List<Integer>> result = solution(candidates, 8);
        printResult(result);
    }

}
