package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode: 95, level: Medium
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTree2 {

    List<TreeNode> solution(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        if(start > end) {
            list.add(null);
            return list;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = solution(start, i - 1);
            List<TreeNode> rightSubtree = solution(i + 1, end);
            
            for(int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for(int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        
        return list;
    }
    
    static void preorder(TreeNode node) {
        if(node == null) {
            System.out.print("null, ");
            return;
        }
        
        System.out.print(node.val + ", ");
        preorder(node.left);
        preorder(node.right);
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTree2 ubst = new UniqueBinarySearchTree2();
        List<TreeNode> list = ubst.solution(1, 3);
        
        for(TreeNode node : list) {
            preorder(node);
            System.out.println();
        }
    }

}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
};
