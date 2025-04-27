package name.lorenzani.andrea.metaprep.insertNodeInPosition;


class Result {

    /*
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER data
     *  3. INTEGER position
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(position==0) {
            newNode.next = llist;
            return newNode;
        }
        changeNode(position, llist, newNode);
        return llist;
    }

    public static void changeNode(int position, SinglyLinkedListNode ll, SinglyLinkedListNode newNode) {
        if(position>1) changeNode(position-1, ll.next, newNode);
        else {
            newNode.next = ll.next;
            ll.next = newNode;
        }
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


