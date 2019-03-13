package treegraph;


/**
 * 
 * @description LeetCode 114, level: Medium
 * 
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 */
public class FlattenBinaryTree {
    
    public static void solution(TreeNode root) {
        if(root == null) {
            return;
        }
        
        solution(root.leftchild);
        solution(root.rightchild);
        
        TreeNode left = root.leftchild;
        TreeNode right = root.rightchild;
        
        root.rightchild = left;
        root.leftchild = null;
        
        while(root.rightchild != null) {
            root = root.rightchild;
        }
        
        root.rightchild = right;
    }
    
    public static void main(String[] args) {
        // create tree
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);

        a.leftchild = b;
        a.rightchild = c;

        b.leftchild = d;
        b.rightchild = e;

        c.rightchild = f;
        
        solution(a);
        
        TreeNode node = a;
        while(node!= null) {
            System.out.println(node.val);
            node = node.rightchild;
        }
    }

}
