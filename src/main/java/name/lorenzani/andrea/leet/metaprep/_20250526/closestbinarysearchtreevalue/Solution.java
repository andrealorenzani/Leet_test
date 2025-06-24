package name.lorenzani.andrea.leet.metaprep._20250526.closestbinarysearchtreevalue;

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
    public int closestValue(TreeNode root, double target) {
        int sol = root.val;
        TreeNode pointer = root;
        while(pointer!=null) {
            double prevDist = Math.abs(((double) sol)-target);
            double currDist = Math.abs(((double)pointer.val)-target);
            if(prevDist>currDist || (prevDist==currDist && sol> pointer.val)) {
                sol = pointer.val;
            }
            if(pointer.val<target) pointer = pointer.right;
            else pointer = pointer.left;
        }
        return sol;
    }
}
