package name.lorenzani.andrea.leet.metaprep._20250530.validatebinarysearch;

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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode reference, Integer max, Integer min) {
        if(reference == null) return true;
        if((min!=null && reference.val<=min) || (max!=null && reference.val>=max)) return false;
        return isValidBST(reference.left, reference.val, min)  &&
                isValidBST(reference.right, max, reference.val);
    }
}
