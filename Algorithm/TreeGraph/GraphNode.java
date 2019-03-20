package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphNode {
    int label;
    List<GraphNode> neighbors;
    GraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
    
    public static void bfs(GraphNode node, int[] visit) {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        visit[node.label] = 1;
        
        while(!q.isEmpty()) {
            node = q.peek();
            q.remove();
            System.out.print(node.label);
            
            for(int i = 0; i < node.neighbors.size(); i++) {
                if(visit[node.neighbors.get(i).label] == 0) {
                    q.add(node.neighbors.get(i));
                    visit[node.neighbors.get(i).label] = 1;
                }
            }
        }
    }
    
    public static void dfs(GraphNode node, int[] visit) {
        if(visit[node.label] == 0) {
            return;
        }
        
        visit[node.label] = 0;
        System.out.print(node.label + " ");
        
        for(int i = 0; i < node.neighbors.size(); i++) {
            if(visit[node.neighbors.get(i).label] == -1) {
                dfs(node.neighbors.get(i), visit);
            }
        }
    }
    
    public static void main(String[] args) {
        GraphNode[] graph = new GraphNode[5];
        
        for(int i = 0; i < 5; i++) {
            graph[i] = new GraphNode(i);
        }
        
        // build graph
        graph[0].neighbors.add(graph[4]);
        graph[0].neighbors.add(graph[2]);
        graph[1].neighbors.add(graph[0]);
        graph[1].neighbors.add(graph[2]);
        graph[2].neighbors.add(graph[3]);
        graph[3].neighbors.add(graph[4]);
        graph[4].neighbors.add(graph[3]);
        
        int[] visit = new int[5];
        
        // bfs
        for(int i = 0; i < 5; i++) {
            System.out.print("from node(" + i + "): ");
            bfs(graph[i], visit);
            System.out.println();
        }
        
        // dfs
        for(int i = 0; i < visit.length; i++) {
            visit[i] = -1;
        }
        
        for(int i = 0; i < graph.length; i++) {
            dfs(graph[i], visit);
        }
    }
}