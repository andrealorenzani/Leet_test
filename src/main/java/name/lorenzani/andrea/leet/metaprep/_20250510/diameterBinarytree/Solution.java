package name.lorenzani.andrea.leet.metaprep._20250510.diameterBinarytree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root)[0];
    }

    private int[] diameter(TreeNode node){
        if(node==null) return new int[]{-1,-1};
        int[] left = diameter(node.left);
        int[] right = diameter(node.right);
        int localDiameter = left[1] + right[1]+2;
        if(localDiameter<left[0]) localDiameter = left[0];
        if(localDiameter<right[0]) localDiameter = right[0];
        int longestPath = Math.max(left[1], right[1])+1;
        return new int[]{localDiameter, longestPath};
    }
}
