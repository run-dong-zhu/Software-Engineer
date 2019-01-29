package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 22, level: Medium
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
  
    public static void generator(int left, int right, String item, List<String> result) {
        if(left == 0 && right == 0) {
            result.add(item);
            return;
        }
        if(left > 0) {
            generator(left - 1, right, item + "(", result);
        }
        if(left < right) {
            generator(left, right - 1, item + ")", result);
        }   
    }
    
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        String item = "";
        generator(n, n, item, result);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = solution(3);
        
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
