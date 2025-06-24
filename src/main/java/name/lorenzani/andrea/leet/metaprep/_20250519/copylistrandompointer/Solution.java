package name.lorenzani.andrea.leet.metaprep._20250519.copylistrandompointer;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node pointer = head;
        Node prev = null;
        Node newList = null;
        while(pointer!=null){
            Node newElem = new Node(pointer.val);
            nodeMap.put(pointer, newElem);
            if(newList == null) newList = newElem;
            else {
                nodeMap.get(prev).next = newElem;
            }
            prev = pointer;
            pointer = pointer.next;
        }
        pointer = head;
        while(pointer!=null) {
            if(pointer.random==null) {
                pointer = pointer.next;
                continue;
            }
            nodeMap.get(pointer).random = nodeMap.get(pointer.random);
            pointer = pointer.next;
        }
        return newList;
    }
}
