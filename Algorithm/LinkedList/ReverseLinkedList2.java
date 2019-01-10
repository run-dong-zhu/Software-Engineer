package linkedList;

/**
 * 
 * @description LeetCode: 92, level: Medium
 * 
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedList2 {
    public static ListNode solution(ListNode head, int m, int n) {
        ListNode result = head;
        
        int reverseLen = n - m + 1;
        
        ListNode preHead = null;
        ListNode postTail = null;
        ListNode next = null;
        ListNode newHead = null;
        
        while(m > 1) {
            preHead = head;
            head = head.next;
            m--;
        }
        
        postTail = head;
       
        while(reverseLen > 0) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            reverseLen--;
        }
        
        postTail.next = head;
        
        if(preHead == null) {
            result = newHead;
        }
        else {
            preHead.next = newHead;
        }
        return result;
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
        
        head = solution(a, 2, 4);
        
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
