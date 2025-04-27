package name.lorenzani.andrea.metaprep.detectLoops;

public class Result {

    static boolean hasCycle(SinglyLinkedListNode head) {
        if(head == null) return false;
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while(fast!=null && fast.next!=null && fast.next.next!=null) {
            if(fast == slow || fast.next == slow || fast.next.next == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(String.format("Fast at %d (%s) and slow at %d (%s)", fast.data, fast, slow.data, slow));
        }
        return false;

    }
}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}