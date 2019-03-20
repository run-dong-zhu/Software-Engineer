package treegraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 207, level: Medium
 *
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    
    static class Graph {
        int label;
        List<Graph> neighbors;
        Graph(int label) {
            this.label = label;
            this.neighbors = new ArrayList<>();
        }
    }
    
    public static boolean dfs(Graph node, List<Integer> visit) {
        visit.set(node.label, 0);
        
        for(int i = 0; i < node.neighbors.size(); i++) {
            if(visit.get(node.neighbors.get(i).label) == -1) {
                if(!dfs(node.neighbors.get(i), visit)) {
                    return false;
                }
            }
            else if(visit.get(node.neighbors.get(i).label) == 0) {
                return false;
            }
        }
        
        visit.set(node.label, 1);
        return true;
    }
    
    public static boolean solution(int numCourses, int[][] prerequisites) {
        // create graph
        List<Graph> graph = new ArrayList<>();
        List<Integer> visit = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++) {
            graph.add(new Graph(i));
            visit.add(-1);
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            Graph begin = graph.get(prerequisites[i][1]);
            Graph end = graph.get(prerequisites[i][0]);
            begin.neighbors.add(end);
        }
        
        for(int i = 0; i < graph.size(); i++) {
            if(visit.get(i) == -1 && !dfs(graph.get(i), visit)) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1}, {1, 0}};
        System.out.println(solution(2, prerequisites));
    }

}
