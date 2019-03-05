package dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @description LeetCode 300, level: Medium
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 */
public class LongestIncreasingSeq {

    public int solution1(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if(i == len) {
                len++;
            }
        }

        return len;
    }
    
    public static void main(String[] args) {
        //int[] nums = {4, 10, 9, 2, 3, 9};
        int[] nums = {4, 5, 6, 7, 7, 7, 101, 18};
        //int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSeq lis = new LongestIncreasingSeq();
        lis.solution1(nums);
    }

}
