package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description LeetCode: 138, level: Medium
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyListWithRandomPointer {
    
    public static void printList(RandomListNode head) {
        while(head != null) {
            if(head.random != null) {
                System.out.println("label: " + head.label + ", random: " + head.random.label);
            }
            else {
                System.out.println("label: " + head.label + ", random: null");
            }
            head = head.next;
        }
    }
    
    public static RandomListNode solution(RandomListNode head) {
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode ptr = head;
        
        while(ptr != null) {
            nodeMap.put(ptr, new RandomListNode(ptr.label));
            ptr = ptr.next;
        }
        
        ptr = head;
        while(ptr != null) {
            nodeMap.get(ptr).next = nodeMap.get(ptr.next);
            nodeMap.get(ptr).random = nodeMap.get(ptr.random);
            ptr = ptr.next;
        }
        
        return nodeMap.get(head);
    }

    public static void main(String[] args) {
        // Create List
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        a.next = b;
        a.random = c;
        
        b.next = c;
        b.random = e;
        
        c.next = d;
        c.random = c;
        
        d.next = e;
        d.random = null;

        e.random = a;
        
        printList(a);
        
        printList(solution(a));
    }

}
