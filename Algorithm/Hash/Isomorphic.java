package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description LeetCode 205, level: Easy
 *
 * https://leetcode.com/problems/isomorphic-strings
 * 
 */
public class Isomorphic {

    public boolean solution(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<>();
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        for(int i = 0; i < sArr.length; i++) {
            if(map.containsKey(sArr[i])) {
                if(map.get(sArr[i]) != tArr[i]) {
                    return false;
                }
            }
            else {
                if(map.containsValue(tArr[i])) {
                    return false;
                }
                map.put(sArr[i], tArr[i]);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Isomorphic imp = new Isomorphic();
        System.out.println(imp.solution("paper", "title"));
        System.out.println(imp.solution("aba", "baa"));
    }

}
