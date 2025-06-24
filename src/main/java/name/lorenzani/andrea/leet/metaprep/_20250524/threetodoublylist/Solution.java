package name.lorenzani.andrea.leet.metaprep._20250524.threetodoublylist;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Solution {

    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        Node[] result = fixNode(root);
        result[0].left = result[1];
        result[1].right = result[0];
        return result[0];
    }

    protected Node[] fixNode(Node root) {
        Node lowest = null;
        Node greatest = null;
        if(root.left == null) lowest = root;
        else {
            Node[] onLow = fixNode(root.left);
            lowest = onLow[0];
            onLow[1].right = root;
            root.left = onLow[1];
        }
        if(root.right == null) greatest = root;
        else {
            Node[] onHigh = fixNode(root.right);
            greatest = onHigh[1];
            onHigh[0].left = root;
            root.right = onHigh[0];
        }
        return new Node[]{lowest, greatest};
    }

}
