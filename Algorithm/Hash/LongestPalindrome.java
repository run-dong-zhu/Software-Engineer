package hash;


/**
 * 
 * @description LeetCode 409, level: Easy
 *
 * https://leetcode.com/problems/longest-palindrome/
 * 
 */
public class LongestPalindrome {
    
    public static int solution(String s) {
        int maxLen = 0;
        int hasOne = 0;
        
        int[] charMap = new int[128];
        
        for(int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i)]++;
        }
        
        for(int j = 0; j < charMap.length; j++) {
            if(charMap[j] % 2 == 0) {
                maxLen += charMap[j];
            }
            else {
                maxLen += charMap[j] - 1;
                hasOne = 1;
            }
        }
        
        return maxLen + hasOne;
    }

    public static void main(String[] args) {
        String s = "abccccddaa";
        System.out.println(solution(s));
    }

}
