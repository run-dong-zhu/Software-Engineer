package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @description LeetCode 39, level: Medium
 *
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    
    public static void printResult(List<List<Integer>> result) {
        for(int i = 0; i < result.size(); i++) {
            List<Integer> item = result.get(i);
            for(int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public static void generator(int index, int target, int[] candidates, List<Integer> item, List<List<Integer>> result) {
        //System.out.println(item);
        if(target < 0) {
            return;
        }
        else if(target == 0) {
            result.add(new ArrayList<>(item));
        }
        else {
            for(int i = index; i < candidates.length; i++) {
                item.add(candidates[i]);
                generator(i, target - candidates[i], candidates, item, result);
                item.remove(item.size() - 1);
            }
        }
    }
    
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        generator(0, target, candidates, item, result);
        
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        
        List<List<Integer>> result = solution(candidates, 7);
        printResult(result);
    }

}
