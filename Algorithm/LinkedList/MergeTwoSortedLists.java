package linkedList;

/**
 * 
 * @description LeetCode 21, level Easy
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {
    
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            }
            else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if(l1 != null) {
            head.next = l1;
        }
        if(l2 != null) {
            head.next = l2;
        }
        
        return result.next;
    }

    public static void main(String[] args) {
        // Create Linkedlist l1
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        
        a.next = b;
        b.next = c;
        
        // Create Linkedlist l2
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(3);
        ListNode z = new ListNode(4);
        
        x.next = y;
        y.next = z;
        
        ListNode head = solution(a, x);
        
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
