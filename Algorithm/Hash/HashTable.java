package hash;

public class HashTable {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    
    ListNode[] table;
    int size;
    
    HashTable(int size) {
        this.size = size;
        this.table = new ListNode[size];
        for(int i = 0; i < size; i++) {
            table[i] = new ListNode(i);
        }
    }
    
    private void insert(int value) {
        int hashKey = value % size;
        ListNode node = table[hashKey];
        while(node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(value);
    }
    
    private int search(int value) {
        int hashKey = value % size;
        ListNode node = table[hashKey];
        while(node != null) {
            if(node.val == value) {
                return hashKey;
            }
            node = node.next;
        }
        return -1;
    }
    
    private void print(ListNode[] table) {
        for(int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "]: ");
            ListNode head = table[i];
            head = head.next;
            while(head != null) {
                System.out.print(head.val + ", ");
                head = head.next;
            }
            System.out.println();
      }
    }

    public static void main(String[] args) {
        HashTable hash = new HashTable(13);
        
        for(int i = 0; i < 128; i++) {
            int val = (int)(Math.random() * 100);
            hash.insert(val);
        }
        
        System.out.println(hash.search(15));
        
        hash.print(hash.table);
    }

}
