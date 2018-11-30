package linkedList;

/**
 * 
 * @description single direction linked list
 *
 */

class Node {
	int key;
	Node next;
	Node(int key) { this.key = key; }
}

public class LinkedList {
		
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		Node node = a;
		
		while(node != null) {
			System.out.println(node.key);
			node = node.next;
		}
	}
	
}
