package TreeAndGraph;

/**
 * 
 * @description Binary Tree and Tree Traversal
 *
 */

class Node {
	String data;
	Node left;
	Node right;
	
	Node(String data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class TreeTraversal {
	
    public void preOrder(Node node) {
    	    System.out.print(node.data + " ");
    	    if(node.left != null) {
    		    preOrder(node.left);
    		}
    	    if(node.right != null) {
    		    preOrder(node.right);
    	    }
    }
    
    public void inOrder(Node node) {
  	    if(node.left != null) {
  		    inOrder(node.left);
  	    }
      	System.out.print(node.data + " ");
  	    if(node.right != null) {
  	  	    inOrder(node.right);
  	    }
    }
    
    public void postOrder(Node node) {
  	    if(node.left != null) {
  		    postOrder(node.left);
  	    }
  	    if(node.right != null) {
  	  	    postOrder(node.right);
  	    }
  	    System.out.print (node.data + " ");
    }

	public static void main(String[] args) {
		// Create a binary tree
		Node g = new Node("g", null, null);
      	Node f = new Node("f", null, null);
      	Node e = new Node("e", null, null);
      	Node d = new Node("d", null, f);
      	Node c = new Node("c", null, g);
      	Node b = new Node("b", d, e);
      	Node a = new Node("a", b, c);
      	
      	TreeTraversal tt = new TreeTraversal();
      	System.out.print("Pre-order: ");
      	tt.preOrder(a);
      	System.out.println();
      	System.out.print("In-order: ");
      	tt.inOrder(a);
      	System.out.println();
      	System.out.print("Post-order: ");
      	tt.postOrder(a);
	}

}
