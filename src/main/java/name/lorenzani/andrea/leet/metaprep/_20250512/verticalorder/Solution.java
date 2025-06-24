package name.lorenzani.andrea.leet.metaprep._20250512.verticalorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
    HashMap<Integer, List<Integer>> pos = new HashMap<>();
    int min = 101;
    int max = -101;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        LinkedList<Position> positions = new LinkedList<>();
        positions.add(new Position(0, root));
        while(!positions.isEmpty()) {
            Position element = positions.pollFirst();
            if(element.node==null) continue;
            pos.putIfAbsent(element.val, new ArrayList<>());
            pos.get(element.val).add(element.node.val);
            if(element.val<min) min=element.val;
            if(element.val>max) max=element.val;
            positions.add(new Position(element.val-1, element.node.left));
            positions.add(new Position(element.val+1, element.node.right));
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=min; i<=max; i++) {
            result.add(pos.get(i));
        }
        return result;
    }
}

class Position {
    TreeNode node;
    int val;
    public Position(int val, TreeNode node) {
        this.val = val;
        this.node = node;
    }
}
