package dynamicprogramming;

/**
 * 
 * @description LeetCode 64, level: Medium
 *
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimunPathSum {
    
    public static int solution(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[][] path = new int[grid.length][grid[0].length];
        
        path[0][0] = grid[0][0];
        
        // init fist row
        for(int i = 1; i < path[0].length; i++) {
            path[0][i] = path[0][i - 1] + grid[0][i]; 
        }
        
        // init fist column
        for(int i = 1; i < path.length; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0]; 
        }
        
        for(int r = 1; r < grid.length; r++) {
            for(int c = 1; c < grid[r].length; c++) {
                path[r][c] = Math.min(path[r - 1][c], path[r][c - 1]) + grid[r][c];
            }
        }
        
        return path[path.length - 1][path[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};
        
        
        System.out.println(solution(grid));

    }

}
