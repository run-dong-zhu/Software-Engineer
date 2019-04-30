package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @description LeetCodee 939, level: Medium
 *
 */
public class MinimumAreaRectangle {

    int solution(int[][] points) {
        if(points.length < 4) {
            return 0;
        }
        
        int area = Integer.MAX_VALUE;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] p : points) {
            if(!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        
        for(int[] p1 : points) {
            for(int[] p2 : points) {
                if(p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    area = Math.min(area, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        
        return area == Integer.MAX_VALUE ? 0 : area;
    }
    
    public static void main(String[] args) {
        MinimumAreaRectangle mar = new MinimumAreaRectangle();
        
        int[][] points = {{1, 1},
                          {1, 3},
                          {3, 1},
                          {3, 3},
                          {2, 2}};
        
        System.out.println(mar.solution(points));
    }

}
