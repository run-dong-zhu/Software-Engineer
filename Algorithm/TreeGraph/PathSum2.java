package treegraph;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @description LeetCode 113, level: Medium
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * Given the below binary tree and sum = 22
 *
 *      5
 *     / \
 *    4   8
 *   /   / \
 *  11  13  4
 *  /  \    / \
 * 7    2  5   1
 * 
 * output:
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 */

class TreeNode {
	int val;
	TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum2 {

    public static boolean isLeaf(TreeNode node) {
	if(node.left != null || node.right != null) {
	    return false;
	}
	else {
	    return true;
	}
    }
	
    public static void traversal(TreeNode node, int pathValue, int sum, List<Integer> path, List<List<Integer>> result) {
	if(node == null) {
	    return;
	}

	pathValue += node.val;
	path.add(node.val);

	if(isLeaf(node) && pathValue == sum) {
	    result.add(new LinkedList<Integer>(path));
	    path.remove(path.size() - 1);
	    return;
	}

	traversal(node.left, pathValue, sum, path, result);
	traversal(node.right, pathValue, sum, path, result);
		
	pathValue -= node.val;
	path.remove(path.size() - 1);
    }
	
    public static List<List<Integer>> solution(TreeNode root, int sum) {
	List<List<Integer>> result = new LinkedList<List<Integer>>();
	List<Integer> path = new LinkedList<Integer>();
	int pathValue = 0;

	traversal(root, pathValue, sum, path, result);
		
	return result;
    }
	
    public static void main(String[] args) {
	// Create BTree
	TreeNode a = new TreeNode(5);
	TreeNode b = new TreeNode(4);
	TreeNode c = new TreeNode(8);
	TreeNode d = new TreeNode(11);
	TreeNode e = new TreeNode(13);
	TreeNode f = new TreeNode(4);
	TreeNode g = new TreeNode(7);
	TreeNode h = new TreeNode(2);
	TreeNode i = new TreeNode(5);
	TreeNode j = new TreeNode(1);
		
	a.left = b;
	a.right = c;
	b.left = d;
	c.left = e;
	c.right = f;
	d.left = g;
	d.right = h;
	f.left = i;
	f.right = j;
		
	List<List<Integer>> pathSum = solution(a, 22);
	    for(int x = 0; x < pathSum.size(); x++) {
		for(int y = 0; y < pathSum.get(x).size(); y++) {
		    System.out.print(pathSum.get(x).get(y) + " ");
		}
		    System.out.println();
	    }
	}

}
