package greedy;

import java.util.Arrays;

/**
 * 
 * @description LeetCode 452, level: Medium
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumArrowsToBurstBalloos {
    
    static int solution(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int arrows = 1;
        int begin = points[0][0];
        int end = points[0][1];
        
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= end) {
                begin = points[i][0];
                if(points[i][1] < end) {
                    end = points[i][1];
                }
            }
            else {
                arrows++;
                begin = points[i][0];
                end = points[i][1];
            }
        }
        
        return arrows;
    }

    public static void main(String[] args) {
        int[][] ballons = {{10, 16},
                            {2, 8},
                            {1, 6},
                            {7, 12}};
        
        // Arrays.sort(ballons);
        // Arrays.sort(ballons, (a, b) -> Integer.compare(a[0], b[0]));
        
        System.out.println(solution(ballons));
    }

}
