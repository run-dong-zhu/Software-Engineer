package linkedList;


/**
 * 
 * @description LeetCode: 141, level: Easy & LeetCode: 142, level: Medium
 * 
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    // 141
    public static boolean solution(ListNode head) {
        ListNode fast = head;
        
        while(fast != null) {
            fast = fast.next;
            if(fast == null) {
                return false;
            }
            head = head.next;
            fast = fast.next;
            if(head == fast) {
                return true;
            }
        }
        return false;
    }
    
    // 142
    public static ListNode solution2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        
        while(fast != null) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast == slow) {
                meet = fast;
                break;
            }
        }
        
        while(meet != null && head != null) {
            if(meet == head) {
                return meet;
            }
            meet = meet.next;
            head = head.next;
        }
        
        return null;
    }

    public static void main(String[] args) {
        // Create Linkedlist
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c;

        System.out.println(solution(a));
        
        if(solution(a)) {
            System.out.println(solution2(a).val);
        }
    }

}
