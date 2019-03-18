package dynamicprogramming;

/**
 * 
 * @description LeetCode 96, level: Medium
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 */
public class UniqueBinarySearchTree {
    
    // LeetCode 96
    int solution(int n) {
        int[] result = new int[n + 1];
        result[0] = result[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        
        return result[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
        System.out.println(ubst.solution(3));

    }

}
