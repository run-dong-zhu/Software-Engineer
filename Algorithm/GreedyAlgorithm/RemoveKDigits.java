package greedy;

import java.util.Stack;

/**
 * 
 * @description LeetCode: 402, level: Medium
 *
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {
    
    public static String solution(String num, int k) {
        StringBuilder result = new StringBuilder();
        
        Stack<Character> stk = new Stack<Character>();
        
        for(int i=0; i < num.length(); i++) {
            char number = num.charAt(i);
            while(!stk.isEmpty() && number < stk.peek() && k > 0) {
                stk.pop();
                k--;
            }
            if(number != '0' || !stk.isEmpty()) {
                stk.push(number);
            }
        }
        
        while(!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }
        
        while(!stk.isEmpty()) {
            result.append(stk.pop());
        }
        
        if(result.length() == 0) {
            return "0";
        }
        
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        System.out.println(solution(num, 1));
    }

}
