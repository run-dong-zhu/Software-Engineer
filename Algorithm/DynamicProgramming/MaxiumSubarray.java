package dynamicprogramming;


/**
 * 
 * @description LeetCode 53, level: Easy
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * 
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxiumSubarray {
    
    public static int maxCross(int[] nums, int l, int m, int r) {
        int sum = 0;
        int left = Integer.MIN_VALUE;
        for(int i = m; i >= l; i--) {
            sum = sum + nums[i];
            
            if(sum > left) {
                left = sum;
            }
        }
        
        sum = 0;
        int right = Integer.MIN_VALUE;
        
        for(int i = m + 1; i <= r; i++) {
            sum = sum + nums[i];
            
            if(sum > right) {
                right = sum;
            }
        }
        
        return left + right;
    }
    
    public static int maxSum(int[] nums, int l, int r) {
        if(l == r) {
            return nums[l];
        }
        
        int mid = (l + r) / 2;
        
        int x = maxSum(nums, l, mid);
        int y = maxSum(nums, mid + 1, r);
        int z = maxCross(nums, l, mid, r);
        
        return Math.max(x, Math.max(y, z));
    }

    public static int solution(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        return maxSum(nums, 0, nums.length - 1);
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, -5, 7, -1, 10, -11, 8, 6};
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        System.out.println(solution(nums));
    }

}
