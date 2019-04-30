package greedy;

/**
 * 
 * @description LeetCode 45, level: Hard
 *
 */
public class JumpGame2 {
    
    static int solution(int nums[]) {
        if(nums.length < 2) {
            return 0;
        }
        
        int jump = 1;
        // max step based on current position
        int currentMax = nums[0];
        // max step within currentMax
        int maxStep = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int step = i + nums[i];
            if(i > currentMax) {
                jump++;
                currentMax = maxStep;
            }
            if(maxStep < step) {
                maxStep = step;
            }
        }
        
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution(nums));
    }

}
