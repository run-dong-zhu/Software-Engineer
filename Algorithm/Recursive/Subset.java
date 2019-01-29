package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 78, level: Medium
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * [
 * ]
 */
public class Subset {
    
    public static void generator(int count, int[] nums, List<Integer> item, List<List<Integer>> result) {
        if(count >= nums.length) {
            return;
        }
        
        item.add(nums[count]);
        result.add(new ArrayList<>(item));
        
        generator(count + 1, nums, item, result);
        item.remove(item.size() - 1);
        generator(count + 1, nums, item, result);
    }
    
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        generator(0, nums, new ArrayList<>(), result);
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> result = solution(nums);
        
        for(int i = 0; i < result.size(); i++) {
            List<Integer> item = result.get(i);
            for(int j = 0; j < item.size(); j++) {
                System.out.print(item.get(j) + " ");
            }
            System.out.println();
        }
    }

}
