package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 51. level: Hard
 *
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    
    public static void printQueens(List<List<String>> result) {
        for(int i = 0; i < result.size(); i++) {
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println();
        }
    }
    
    public static boolean isSafe(List<String> item) {
        for(int i = 0; i < item.size(); i++) {
            int col = item.get(i).indexOf('Q');
            for(int j = i + 1; j < item.size(); j++) {
                String line = item.get(j);
                if(line.charAt(col) == 'Q') {
                    return false;
                }
                if(col - (j - i) >= 0 && line.charAt(col - (j - i)) == 'Q') {
                    return false;
                }
                if(col + (j - i) < item.size() && line.charAt(col + (j - i)) == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void generator(int n, int row, List<String> item, List<List<String>> result) {
        if(row == n) {
            result.add(new ArrayList<>(item));
        }
        else {
            for(int col = 0; col < n; col++) {
                StringBuilder line = new StringBuilder();
                for(int i = 0; i < n; i++) {
                    line.append('.');
                }
                line.setCharAt(col, 'Q');
                item.add(line.toString());
                if(isSafe(item)) {
                    generator(n, row + 1, item, result);
                }
                item.remove(item.size() - 1);
            }
        }
    }
    
    public static List<List<String>> solution(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> item = new ArrayList<>();
        
        generator(n, 0, item, result);
        
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = solution(5);
        
        printQueens(result);
    }

}
