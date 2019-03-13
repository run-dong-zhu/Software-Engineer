package treegraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 199, level: Medium
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 */
public class BinaryTreeRightSideView {
    
    public static void traverse(TreeNode node, int level, List<Integer> result) {
        if(node == null) {
            return;
        }
        
        if(result.size() <= level) {
            result.add(node.val);
        }
        
        traverse(node.rightchild, level + 1, result);
        traverse(node.leftchild, level + 1, result);
        
        //level--;
    }
    
    public static List<Integer> solution(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        traverse(node, 0, result);
        return result;
    }

    public static void main(String[] args) {
        
        // create tree
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);

        a.leftchild = b;
        a.rightchild = c;

        b.leftchild = d;
        b.rightchild = e;

        c.rightchild = f;
        
        e.leftchild = g;
        
        List<Integer> result = solution(a);
        System.out.println(result);
    }

}
