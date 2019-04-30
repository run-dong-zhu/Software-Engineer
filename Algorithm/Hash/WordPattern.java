package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description LeetCode 290, level: Easy
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 */
public class WordPattern {
    
    public static boolean solution(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        
        String[] strArr = str.split(" ");
        
        if(strArr.length != pattern.length()) {
            return false;
        }
        
        for(int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(strArr[i])) {
                    return false;
                }
            }
            else {
                if(map.containsValue(strArr[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strArr[i]);
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "cat dog dog cat";
        System.out.println(solution(pattern, str));
    }

}
