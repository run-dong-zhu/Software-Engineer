package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description LeetCode 3, level: Medium
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3
 */

public class LongestSubstringWithoutRepeat {

    public static int solution(String s) {
        int pointer = 0;
        int begin = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(pointer < s.length()) {
            if(map.containsKey(s.charAt(pointer))) {
                begin = Math.max(map.get(s.charAt(pointer)), begin);
            }
            result = Math.max(result, pointer - begin + 1);
            map.put(s.charAt(pointer), pointer + 1);
            pointer++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
       //String s = "abcbadab";
       String s = "abcbadebc";
       //String s = "abba";
       System.out.println(solution(s));
    }

}
