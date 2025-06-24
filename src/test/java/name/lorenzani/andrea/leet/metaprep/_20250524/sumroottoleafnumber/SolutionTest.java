package name.lorenzani.andrea.leet.metaprep._20250524.sumroottoleafnumber;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasic() {
        Solution s = new Solution();

        assertEquals(1026, s.sumNumbers(generateTreenode(new int[] {4,9,0,5,1})));
    }

    private TreeNode generateTreenode(int[] nodes) {
        return generateTreenode(nodes, 0);
    }
    private TreeNode generateTreenode(int[] nodes, int pos) {
        TreeNode root = new TreeNode(nodes[pos]);
        if(pos*2+1 < nodes.length) root.left = generateTreenode(nodes, pos*2+1);
        if(pos*2+2 < nodes.length) root.right = generateTreenode(nodes, pos*2+2);
        return root;
    }

}