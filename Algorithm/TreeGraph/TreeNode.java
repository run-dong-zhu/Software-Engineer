package treegraph;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode leftchild;
    TreeNode rightchild;
    TreeNode(int x) {
        this.val = x;
    }
    
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        preOrder(root.leftchild);
        preOrder(root.rightchild);
    }
    
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.leftchild);
        System.out.print(root.val);
        inOrder(root.rightchild);
    }
    
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.leftchild);
        postOrder(root.rightchild);
        System.out.print(root.val);
    }
    
    public static void breadthFirstSearch(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.peek();
            q.poll();
            System.out.print(node.val);
            if(node.leftchild != null) {
               q.add(node.leftchild);
            }
            if(node.rightchild != null) {
                q.add(node.rightchild);
            }
        }
    }
    
    // test
    public static void main(String[] args) {
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
        
        preOrder(a);
        System.out.println();
        inOrder(a);
        System.out.println();
        postOrder(a);
        System.out.println();
        breadthFirstSearch(a);
    }
}
