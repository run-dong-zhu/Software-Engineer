package linkedList;

/**
 * 
 * @description LeetCode 206, level: Easy
 * 
 * Reverse a singly linked list.
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */

public class ReverseLinkedList {

    public static ListNode solution(ListNode head) {
	    ListNode newHead = null;
	    ListNode next = null;

	    while(head != null) {
	        next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }

	    return newHead;
	}
	
    public static void main(String[] args) {
        // Create Linkedlist
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode head = a;

        while(head != null) {
            if(head.next != null) {
                System.out.print(head.val + " -> ");
            }
            else {
                System.out.println(head.val);
            }
            head = head.next;
        }

        head = solution(a);
        
        while(head != null) {
            if(head.next != null) {
                System.out.print(head.val + " -> ");
            }
            else {
                System.out.println(head.val);
            }
            head = head.next;
        }
    }
}
