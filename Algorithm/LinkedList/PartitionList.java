package linkedList;

/**
 * 
 * @description LeetCode: 86, level: Medium
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */

public class PartitionList {
    
    public static void printList(ListNode head) {
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
    
    public static ListNode solution(ListNode head, int x) {
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        
        while(head != null) {
            ListNode next = head.next;
            if(head.val > x) {
                large.next = head;
                large = head;
            }
            else {
                small.next = head;
                small = head;
            }
            head = next;
        }
        
        small.next = largeHead.next;
        large.next = null;
        
        return smallHead.next;
    }

    public static void main(String[] args) {
        // Create Linkedlist
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        
        printList(a);
        printList(solution(a, 5));
    }

}
