package dynamicprogramming;

/**
 * 
 * @description LeetCode 322, level: Medium
 *
 * https://leetcode.com/problems/coin-change/
 * 
 */
public class CoinsChange {

    public static int solution(int[] coins, int amount) {
        if(coins.length < 0 || amount < 0) {
            return -1;
        }
        
        int[] nums = new int[amount + 1];
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }
        
        nums[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j] && nums[i - coins[j]] != -1) {
                    if(nums[i] == -1 || nums[i] > nums[i - coins[j]] + 1)
                        nums[i] = nums[i - coins[j]] + 1;
                }
            }
        }
        
        return nums[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(solution(coins, 11));
    }

}
