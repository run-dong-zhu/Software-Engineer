package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description LeetCode 49, level: Medium
 *
 * Given an array of strings, group anagrams together.
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *  ["ate","eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 */
public class GroupAnagrams {
    
    public static String sortStr(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String result = new String(arr);
        return result;
    }

    public static List<List<String>> solution(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            String str = sortStr(strs[i]);
            if(!map.containsKey(str)) {
                List<String> item = new ArrayList<>();
                item.add(strs[i]);
                map.put(str, item);
                result.add(item);
            }
            else {
                map.get(str).add(strs[i]);
            }
        }
        
        return result;
    }
       
    public static void main(String[] args) {
       String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
       List<List<String>> result = solution(strs);
       
       for(int i = 0; i < result.size(); i++) {
           System.out.println(result.get(i));
       }
    }

}
