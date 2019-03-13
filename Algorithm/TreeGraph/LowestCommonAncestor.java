package treegraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @description LeetCode 236, level: Medium
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public static void traverse(TreeNode node, TreeNode target, List<TreeNode> branch, List<TreeNode> result, boolean find) {        
        if(node == null || find) {
            return;
        }

        branch.add(node);
        
        if(node == target) {
            for(int i = 0; i < branch.size(); i++) {
                result.add(branch.get(i));
            }
            find = true;
        }
        
        traverse(node.leftchild, target, branch, result, find);
        traverse(node.rightchild, target, branch, result, find);

        branch.remove(branch.size() - 1);
    }
    
    public static TreeNode solution(TreeNode root, TreeNode node1, TreeNode node2) {
        List<TreeNode> findA = new ArrayList<>();
        boolean find = false;
        traverse(root, node1, new ArrayList<>(), findA, find);
        
        List<TreeNode> findB = new ArrayList<>();
        traverse(root, node2, new ArrayList<>(), findB, false);
        
        int i = 0;
        int j = 0;
        
        TreeNode lca = null;
        
        while(i < findA.size() && j < findB.size()) {
            if(findA.get(i) == findB.get(j)) {
                lca = findA.get(i);
                i++;
                j++;
            }
            else {
                break;
            }
        }
        
        return lca;
    }
    
    public static TreeNode solution2(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || root == node1 || root == node2) {
            return root;
        }
        TreeNode left = solution2(root.leftchild, node1, node2);
        TreeNode right = solution2(root.rightchild, node1, node2);
        
        return left != null ? left : right;
    }
    
    // Iterative Method
    public static TreeNode solution3(TreeNode root, TreeNode node1, TreeNode node2) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        parent.put(root, null);
        stack.push(root);
        
        while(!parent.containsKey(node1) || !parent.containsKey(node2)) {
            TreeNode node = stack.pop();
            
            if(node.leftchild != null) {
                parent.put(node.leftchild, node);
                stack.push(node.leftchild);
            }
            
            if(node.rightchild != null) {
                parent.put(node.rightchild, node);
                stack.push(node.rightchild);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        
        while(node1 != null) {
            ancestors.add(node1);
            node1 = parent.get(node1);
        }
        
        while(!ancestors.contains(node2)) {
            node2 = parent.get(node2);
        }
        
        return node2;
    }

    public static void main(String[] args) {
        // create a tree
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);
          
        a.leftchild = b;
        a.rightchild = c;

        b.leftchild = d;
        b.rightchild = e;

        c.leftchild = f;
        c.rightchild = g;

        e.leftchild = h;
        e.rightchild = i;
        
//        TreeNode node = solution(a, b, c);
        TreeNode node = solution2(a, d, b);
//        TreeNode node = solution3(a, d, h);
        System.out.println(node.val);
    }

}
