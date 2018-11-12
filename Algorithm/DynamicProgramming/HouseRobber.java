package dynamic.programming;

/**
 * 
 * @description  LeetCode 198, level: Easy
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night. 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
 * money you can rob tonight without alerting the police.
 * 
 * Input: [2,7,9,3,1] 
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber {
	public int solution(int[] houses) {
		if(houses.length == 0) {
			return 0;
		}
		
		if(houses.length == 1) {
			return houses[0];
		}
		
		int money[] = new int[houses.length];
		money[0] = houses[0];
		money[1] = Math.max(houses[0], houses[1]);
		
		int i = 2;
		while(i < money.length) {
			money[i] = Math.max(money[i - 2] + houses[i], money[i - 1]);
			i++;
		}
		
		return money[money.length - 1];
	}

	public static void main(String[] args) {
		int[] houses = {2, 7, 9, 15, 1};
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.solution(houses));
	}

}
