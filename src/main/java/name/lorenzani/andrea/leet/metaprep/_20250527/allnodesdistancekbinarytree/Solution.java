package name.lorenzani.andrea.leet.metaprep._20250527.allnodesdistancekbinarytree;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     TreeNode(int x, TreeNode left, TreeNode right) {
          val = x;
          this.left = left;
          this.right = right;
     }
 }

public class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        search(root, target, k, 1, result);
        return result;
    }

    public Integer search(TreeNode root, TreeNode target, int k, int depth, ArrayList<Integer> result) {
        if(root==null) return null;
        if(root == target) {
            if(k==0) {
                result.add(root.val);
            }
            else {
                search(root.left, target, k, -1, result);
                search(root.right, target, k, -1, result);
            }
            return -1;
        }
        if(k>0 && depth+k==0) {
            result.add(root.val);
        }
        else {
            Integer valL = search(root.left, target, k, depth>=0?depth+1:depth-1, result);
            if(valL!=null && valL<0) {
                if(valL+k==0) {
                    result.add(root.val);
                }
                else {
                    search(root.right, target, k, valL - 1, result);
                }
                return valL -1;
            }
            Integer valR = search(root.right, target, k, depth>0?depth+1:depth-1, result);
            if(valR!=null && valR<0) {
                if(valR+k==0) {
                    result.add(root.val);
                }
                else if(valL!=null) {
                    search(root.left, target, k, valR - 1, result);
                }
                return valR -1;
            }
        }
        return depth+1;
    }
}
