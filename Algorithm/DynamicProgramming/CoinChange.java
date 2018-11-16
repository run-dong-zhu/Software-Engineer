package dynamic.programming;

/**
 * 
 * @description LeetCode 322, level: Medium
 * 
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {
	public int solution(int[] coins, int amount) {
		int[] change = new int[amount + 1];
		
		change[0] = 0;
		
		for(int i = 1; i < change.length; i++) {
			change[i] = -1;
		}
		
		for(int i = 1; i < change.length; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0 && change[i - coins[j]] != -1) {
					if(change[i] == -1 || change[i] > change[i - coins[j]] + 1) {
						change[i] = change[i - coins[j]] + 1;
					}
				}
			}
		}
		return change[amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5, 7, 10};
		CoinChange cc = new CoinChange();
		System.out.println(cc.solution(coins, 17));
		System.out.println(cc.solution(coins, 51));
	}

}
