package stackandqueue;

import java.util.PriorityQueue;

/**
 * 
 * @description LeetCode 215, level: Easy
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {
    
    static int solution(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                q.add(nums[i]);
            }
            else if(nums[i] > q.peek()) {
                q.poll();
                q.add(nums[i]);
            }
        }
        
        return q.poll();
    }

    public static void main(String[] args) {
        int[] nums = {10, 8, 17, 1, 6, 3, 9};
        
        System.out.println(solution(nums, 3));
    }

}
