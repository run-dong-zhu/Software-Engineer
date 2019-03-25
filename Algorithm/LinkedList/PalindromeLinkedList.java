package linkedList;

/**
 * 
 * @description LeetCode 234, level: Easy
 *
 */
public class PalindromeLinkedList {
    
    boolean solution(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode half = slow;
        
        //reverse half List
        ListNode newHead = null;
        if(fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
                ListNode next = slow.next;
                slow.next = newHead;
                newHead = slow;
                slow = next;
        }
        
        while(newHead != null && head != half) {
            if(newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // create linked list
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
    }

}
