package greedy;

/**
 * 
 * @description LeetCode: 376, level: Medium
 * 
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {

    public static int solution(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = -1;
        
        int direction = BEGIN;
        int len = 1;
        
        for(int i = 1; i < nums.length; i++) {
            switch(direction) {
                case BEGIN:
                    if(nums[i - 1] < nums[i]) {
                        direction = UP;
                        len++;
                    }
                    else {
                        direction = DOWN;
                        len++;
                    }
                    break;
                case UP:
                    if(nums[i - 1] > nums[i]) {
                        direction = DOWN;
                        len++;
                    }
                    break;
                case DOWN:
                    if(nums[i - 1] < nums[i]) {
                        direction = UP;
                        len++;
                    }
                    break;
            }
        }

        return len;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        
        System.out.println(solution(nums));
    }

}
