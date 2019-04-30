package hash;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {

    /**
     * 
     * @param sMap
     * @param tMap
     * @param vec
     * @return if substring contains all characters in tMap
     */
    private boolean isWindowOK(int[] sMap, int[] tMap, List<Integer> vec) {
        for(int i = 0; i < vec.size(); i++) {
            if(sMap[vec.get(i)] < tMap[vec.get(i)]) {
                return false;
            }
        }
        
        return true;
    }
    
    public String solution(String s, String t) {
        final int MAX_LEN = 128;
        int[] tMap = new int[MAX_LEN];
        int[] sMap = new int[MAX_LEN];
        
        List<Integer> vec = new ArrayList<>();
        
        for(int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        
        for(int i = 0; i < MAX_LEN; i++) {
            if(tMap[i] > 0) {
                vec.add(i);
            }
        }
        
        int begin = 0;
        String result = "";
        
        for(int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i)]++;
            while(begin < i) {
                char beginChar = s.charAt(begin);
                // not a character in t
                if(tMap[beginChar] == 0) {
                    begin++;
                }
                // duplicate character in t
                else if(sMap[beginChar] > tMap[beginChar]) {
                    sMap[beginChar]--;
                    begin++;
                }
                else {
                    break;
                }
            }
            
            if(isWindowOK(sMap, tMap, vec)) {
                int len = i - begin + 1;
                if(result == "" || len < result.length()) {
                    result = s.substring(begin, i + 1);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        
        System.out.println(mws.solution(s, t));
    }

}
