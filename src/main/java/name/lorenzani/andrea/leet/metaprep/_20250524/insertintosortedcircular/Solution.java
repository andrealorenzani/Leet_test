package name.lorenzani.andrea.leet.metaprep._20250524.insertintosortedcircular;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class Solution {

    public Node insert(Node head, int insertVal) {
        Node result = new Node(insertVal);
        if(head == null) {
            result.next = result;
            return result;
        }
        if(head.next == head) {
            head.next = result;
            result.next = head;
            return head;
        }

        Node pointer = head;
        Node prev = head;
        if(insertVal < head.val) {
            while (pointer.next.val >= pointer.val) {
                pointer = pointer.next;
                if(pointer == head) break;
            }
            if(pointer.next.val<insertVal) pointer = pointer.next;
        }
            while(insertVal>pointer.next.val && pointer.next.val >= pointer.val){
                pointer = pointer.next;
                if(pointer == head) break;
            }

        result.next = pointer.next;
        pointer.next = result;
        return head;
    }

    public Node insertOld(Node head, int insertVal) {
        Node result = new Node(insertVal);
        if(head == null) {
            result.next = result;
            return result;
        }
        if(head.next == head) {
            head.next = result;
            result.next = head;
            return head;
        }

        Node pointer = head;
        Node prev = head;
        if(insertVal < head.val) {
            while (pointer.next.val >= pointer.val) {
                pointer = pointer.next;
                if(pointer == head) break;
            }
            while (insertVal > pointer.next.val) {
                pointer = pointer.next;
                if(pointer == head) break;
            }
        }
        else {
            while(insertVal>pointer.next.val && pointer.next.val >= pointer.val){
                pointer = pointer.next;
                if(pointer == head) break;
            }
        }
        result.next = pointer.next;
        pointer.next = result;
        return head;
    }

}
