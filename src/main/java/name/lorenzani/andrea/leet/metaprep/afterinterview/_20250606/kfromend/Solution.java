package name.lorenzani.andrea.leet.metaprep.afterinterview._20250606.kfromend;

public class Solution {

    public void removeKFromEnd(Node root, int k) {
        int pos=-1;
        Node pointer = root;
        Node kp = null;

        while(pointer != null) {
            pointer = pointer.next;
            pos += 1;
            if(kp!=null) kp = kp.next;
            if(pos == k) kp = root;
        }
        if(kp!=null) kp.next = kp.next.next;
    }

}

class Node {
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return "val=" + val +
                " next=" + ((next==null)?"null":next.toString());
    }
}
