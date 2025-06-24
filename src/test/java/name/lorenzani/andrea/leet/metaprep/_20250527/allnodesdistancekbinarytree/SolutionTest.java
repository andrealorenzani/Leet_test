package name.lorenzani.andrea.leet.metaprep._20250527.allnodesdistancekbinarytree;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest extends TestCase {

    public void testFailing1() {
        Solution s = new Solution();

        TreeNode node = generateTreenode(new Integer[]{0, 2, 1, null, null, 3});
        List<Integer> expected = new ArrayList<>();
        expected.add(2);

        Assert.assertArrayEquals(expected.toArray(), s.distanceK(node, node.right.left, 3).toArray());
    }

    public void testFailing2() {
        Solution s = new Solution();

        TreeNode node = generateTreenode(new Integer[]{0, 1, null, null, 2, null, null, null, null, null, 3, null, null, null, null, null, null, null, null, null, null, null, 4});
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        Assert.assertArrayEquals(expected.toArray(), s.distanceK(node, node.left.right.right, 0).toArray());
    }

    public void testFailing3() {
        Solution s = new Solution();

        TreeNode node = generateTreenode(new Integer[]{0, 1, 3, null, 2, 4, null, null, null, 5, null, null, null, null, null, null, null, null, null, null, null, null, 6});
        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        Assert.assertArrayEquals(expected.toArray(), s.distanceK(node, node.right.left, 3).toArray());
    }

    public void testFailing4() {
        Solution s = new Solution();

        TreeNode node = new TreeNode(0, new TreeNode(5), new TreeNode(1, new TreeNode(2, null, new TreeNode(3, new TreeNode(4, new TreeNode(7), null), null)), new TreeNode(6)));
        List<Integer> expected = new ArrayList<>();
        expected.add(2);

        Assert.assertArrayEquals(expected.toArray(), s.distanceK(node, node.right.left.right.left.left, 3).toArray());
    }

    private TreeNode generateTreenode(Integer[] nodes) {
        return generateTreenode(nodes, 0);
    }
    private TreeNode generateTreenode(Integer[] nodes, int pos) {
        if(nodes[pos] == null) return null;
        TreeNode root = new TreeNode(nodes[pos]);
        if(pos*2+1 < nodes.length) root.left = generateTreenode(nodes, pos*2+1);
        if(pos*2+2 < nodes.length) root.right = generateTreenode(nodes, pos*2+2);
        return root;
    }

}