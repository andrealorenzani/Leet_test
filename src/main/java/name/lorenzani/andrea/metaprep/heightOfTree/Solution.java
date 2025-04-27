package name.lorenzani.andrea.metaprep.heightOfTree;

public class Solution {

    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static int height(Node root) {
        if(root == null) return 0;
        int heightLeft = (root.left==null)? 0 : 1 + height(root.left);
        int heightRight = (root.right==null)? 0 : 1 + height(root.right);
        return Math.max(heightLeft, heightRight);
    }

}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
