package name.lorenzani.andrea.leet.metaprep._20250511.lowestCommonAncestor;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  class Result {
    TreeNode result;
    boolean foundP;
    boolean foundQ;

    public Result(){
        result = null;
        foundP = false;
        foundQ = false;
    }
      public Result(TreeNode result, boolean foundP, boolean foundQ){
          this.result = result;
          this.foundP = foundP;
          this.foundQ = foundQ;
      }
  }

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = findPorQ(root, p, q);
        return res.result;
    }

    public Result findPorQ(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return new Result(null, false, false);
        boolean foundQ = q==null || root.val == q.val;
        boolean foundP = p==null || root.val == p.val;
        if(foundP && foundQ) {
            return new Result(null, p != null, q != null);
        }
        Result left = findPorQ(root.left, foundP?null:p, foundQ?null:q);
        if(left.result!=null) return left;
        if(foundP && left.foundQ) {
            return new Result(p==null?null:root, p != null, true);
        }
        if(foundQ && left.foundP) {
            return new Result(q==null?null:root, true, q != null);
        }
        Result right = findPorQ(root.right, foundP||left.foundP?null:p, foundQ|| left.foundQ?null:q);
        if(right.result!=null) return right;
        foundQ = q!=null && (root.val == q.val || left.foundQ || right.foundQ);
        foundP = p!=null && (root.val == p.val || left.foundP || right.foundP);
        return new Result((foundP&&foundQ)?root:null, foundP, foundQ);
    }
}
