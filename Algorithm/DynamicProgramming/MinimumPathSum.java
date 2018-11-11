package dynamic.programming;

/**
 * 
 * @description LeetCode: 64, level: Medium
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {
	
	public int solution(int[][] grid) {
		if(grid.length == 0) {
			return 0;
		}
		
		int[][] path = new int[grid.length][grid[0].length];
		path[0][0] = grid[0][0];
		
		// init first row
		for(int i = 1; i < grid[0].length; i++) {
			path[0][i] = path[0][i - 1] + grid[0][i];
		}
		
		for(int j = 1; j < grid.length; j++) {
			path[j][0] = path[j - 1][0] + grid[j][0];
			for(int k = 1; k < grid[0].length; k++) {
				path[j][k] = Math.min(path[j][k - 1], path[j - 1][k]) + grid[j][k];
			}
		}
		
		return path[path.length - 1][path[0].length - 1];
	}

	public static void main(String[] args) {

		int[][] grid = {{1, 3, 1},
					    {1, 5, 1},
					    {4, 2, 1}};
		
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.solution(grid));
	}

}
