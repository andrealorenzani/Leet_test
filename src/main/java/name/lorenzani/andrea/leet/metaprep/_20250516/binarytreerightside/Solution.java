package name.lorenzani.andrea.leet.metaprep._20250516.binarytreerightside;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();

        ArrayList<Integer> right = new ArrayList<>(List.of(root.val));
        right.addAll(rightSideView(root.right));
        ArrayList<Integer> left = new ArrayList<>(List.of(root.val));
        left.addAll(rightSideView(root.left));
        if(left.size() <= right.size()) return right;
        for(int i= right.size();i< left.size(); i++){
            right.add(left.get(i));
        }
        return right;
    }
}
