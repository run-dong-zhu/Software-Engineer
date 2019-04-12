package stackandqueue;

import java.util.Stack;

/**
 * 
 * @description LeetCode 20, level: Easy
 * 
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        } 
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(')');
            }         
            else if(s.charAt(i) == '{') {
                stack.push('}');
            }
            else if(s.charAt(i) == '[') {
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "(){[]}";
        
        ValidParentheses vp = new ValidParentheses();
        
        System.out.println(vp.isValid(s));
    }

}
