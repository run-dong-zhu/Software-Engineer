package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @description LeetCode 187, level: Medium
 *
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDNASeq {

    public static List<String> solution(String s) {
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int i = 0;
        while(i + 10 < s.length()) {
            String seq = s.substring(i, i + 10);

            if(map.containsKey(seq)) {
                map.put(seq, map.get(seq) + 1);
            }
            else {
                map.put(seq, 1);
            }
            
            i++;
        }
        
        for(String str : map.keySet()) {
            if(map.get(str) > 1) {
                result.add(str);
            }
        }
        return result;
    }
    
    public static List<String> solution2(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> twice = new HashSet<>();
        
        List<String> result = new ArrayList<>();
        
        if(s.length() < 10) {
            return result;
        }
        
        char[] map = new char[26];
        
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && twice.add(v)) {
                result.add(s.substring(i, i + 10));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solution(s));
        
        String dna = "AAAAAAAAAAA";
        System.out.println(solution(dna));
        System.out.println(solution2(dna));
    }

}
