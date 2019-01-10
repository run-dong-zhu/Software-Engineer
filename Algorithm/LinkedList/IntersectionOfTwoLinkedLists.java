package linkedList;

/**
 * 
 * @description LeetCode 160, level: Easy
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

public class IntersectionOfTwoLinkedLists {
    
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
    
    public static int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    public static ListNode alignment(ListNode head, int step) {
        while(step > 0) {
            head = head.next;
            step--;
        }
        return head;
    }
    
    public static ListNode solution(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int step = 0;
        
        
        if(lenA > lenB) {
            step = lenA - lenB;
            headA = alignment(headA, step);
        }
        else {
            step = lenB - lenA;
            headB = alignment(headB, step);
        }
        
        while(headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }

    public static void main(String[] args) {
        // Create ListNodes
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(1);
        
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(0);
        ListNode e = new ListNode(1);
        
        ListNode x = new ListNode(8);
        ListNode y = new ListNode(4);
        ListNode z = new ListNode(5);

        // Linked listNodes
        a.next = b;
        b.next = x;
        
        c.next = d;
        d.next = e;
        e.next = x;
        
        x.next = y;
        y.next = z;
        
        printList(a);
        printList(c);
        
        if(solution(a, c) != null) {
            System.out.println("Intersection of two list is: " + solution(a, c).val);
        }
        else {
            System.out.println("No intersection!");
        }
    }

}
