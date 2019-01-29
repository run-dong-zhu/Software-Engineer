package recursive;

import java.util.Arrays;


/**
 * 
 * @description LeetCode: 473, level: Medium
 *
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class MatchsticksToSquare {
    
    public static boolean generator(int n, int[] matches, int target, int[] sides) {
        if(n < 0) {
            return true;
        }
        
        for(int i = 0; i < 4; i++) {
            if(sides[i] + matches[n] > target) {
                continue;
            }
            sides[i] += matches[n];
            if(generator(n - 1, matches, target, sides)) {
                return true;
            }
            sides[i] -= matches[n];
        }
        
        return false;
    }
    
    public static boolean solution(int[] matches) {
        if(matches.length < 4) {
            return false;
        }
        
        int sum = 0;
        int index = 0;
        while(index < matches.length) {
            sum += matches[index];
            index++;
        }
        if(sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(matches);
        int[] sides = {0, 0, 0, 0};

        return generator(matches.length - 1, matches, sum / 4, sides);
    }

    public static void main(String[] args) {
        int[] matches = {1, 1, 2, 2, 2};
        System.out.println(solution(matches));
    }

}
