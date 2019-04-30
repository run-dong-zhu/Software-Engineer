package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description LeetCode 760, level: Easy
 *
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * 
 * e.g.
 * A = [12, 28, 46, 32, 50], B = [50, 12, 32, 46, 28]
 * should return
 * [1, 4, 3, 2, 0]
 */
public class FindAnagramMappings {

    public int[] solution(int[] A, int[] B) {
        
        if(A.length != B.length) {
            return null;
        }
        
        int[] result = new int[A.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < B.length; i++) {
            map.computeIfAbsent(B[i], k -> new ArrayList<>()).add(i);
        }
        
        for(int j = 0; j < A.length; j++) {
            result[j] = map.get(A[j]).remove(map.get(A[j]).size() - 1);
        }
        
        return result;
    }
    
    public int[] solution2(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        
        for(int j = 0; j < A.length; j++) {
            if(map.containsKey(A[j])) {
                result[j] = map.get(A[j]);
            }
            else {
                result[j] = -1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] a = {12, 28, 46, 32, 50};
        int[] b = {50, 12, 32, 46, 28};
        
        FindAnagramMappings fam = new FindAnagramMappings();
        int[] result = fam.solution(a, b);
        
        for(int x : result) {
            System.out.print(x + ", ");
        }
    }

}
