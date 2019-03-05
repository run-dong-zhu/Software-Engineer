package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 120, level: Medium
 *
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() < 1) {
            return 0;
        }
        
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        
        List<List<Integer>> path = new ArrayList<>();
        
        for(int i = 0; i < triangle.size(); i++) {
            path.add(new ArrayList<>());
        }
        
        int height = triangle.size();
        
        // Init last layer
        path.set(height - 1, triangle.get(height - 1));
        
        for(int i = height - 2; i >= 0; i--) {
            List<Integer> level = path.get(i);
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int steps = Math.min(path.get(i + 1).get(j), path.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                level.add(j, steps);
            }
            //path.set(i, level);
        }
        
        return path.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);
        
        for(int i = 0; i < triangle.size(); i++) {
            System.out.println(triangle.get(i));
        }
        
        System.out.println(minimumTotal(triangle));
    }

}
