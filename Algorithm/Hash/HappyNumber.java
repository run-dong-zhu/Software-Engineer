package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @description LeetCode 202, level: Easy
 *
 * https://leetcode.com/problems/happy-number/
 * 
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        
        int mod = 0;
        
        while(n != 1) {
            int sum = 0;
            while(n > 0) {
                mod = n % 10;
                sum += mod * mod;
                n = n / 10;
            }
            n = sum;
            if(set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(1));
    }

}
