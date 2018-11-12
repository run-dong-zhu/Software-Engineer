package dynamic.programming;

/**
 * 
 * @description 	LeetCode 70, level: Easy
 * You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class ClimbingStairs {
	
	public int solution(int stairs) {
		if(stairs < 2) {
			return 1;
		}
		
		int[] ways = new int[stairs + 1];
		ways[1] = 1;
		ways[2] = 2;
		
		int index = 3;
		while(index <= stairs) {
			ways[index] = ways[index - 1] + ways[index - 2];
			index++;
		}
		
		return ways[stairs];
	}

	public static void main(String[] args) {
		int stairs = 3;
		
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.solution(stairs));
	}

}
