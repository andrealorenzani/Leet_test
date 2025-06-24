package name.lorenzani.andrea.leet.metaprep._20250524.sumroottoleafnumber;

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

public class Solution {
    public int sumNumbers(TreeNode root) {
        return (int) generateNumbers(root).stream().mapToLong(i -> Long.parseLong(i.toString())).sum();
    }

    public ArrayList<StringBuilder> generateNumbers(TreeNode root){
        ArrayList<StringBuilder> result = new ArrayList<>();
        if(root == null) return result;
        ArrayList<StringBuilder> childrenNumbers = generateNumbers(root.left);
        childrenNumbers.addAll(generateNumbers(root.right));
        if(childrenNumbers.isEmpty()) {
            StringBuilder sb = new StringBuilder(String.valueOf(root.val));
            result.add(sb);
            return result;
        }
        for(StringBuilder child: childrenNumbers) {
            result.add(child.insert(0, root.val));
        }
        return result;
    }
}
