package recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @description traverse a linked list by recursion
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}


public class RecursiveLinkedList {
    
    public static void recursiveList(ListNode head, List<Integer> list) {
        if(head == null) {
            return;
        }
        list.add(head.val);
        recursiveList(head.next, list);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        
        //ListNode head = a;
        List<Integer> list = new LinkedList<Integer>();
        
        recursiveList(a, list);
        
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
