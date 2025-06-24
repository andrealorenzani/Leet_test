package name.lorenzani.andrea.leet.metaprep.afterinterview._20250606.kfromend;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        Node root = new Node(1);
        Node pt = root;
        pt.next = new Node(2);
        pt = pt.next;
        pt.next = new Node(3);
        pt = pt.next;
        pt.next = new Node(4);
        pt = pt.next;
        pt.next = new Node(5);
        pt = pt.next;
        pt.next = new Node(6);
        pt = pt.next;

        Solution s = new Solution();
        s.removeKFromEnd(root, 2);
        System.out.println("Result " + root);
    }

}