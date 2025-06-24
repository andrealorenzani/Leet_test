package name.lorenzani.andrea.leet.metaprep._20250519.verticaltraversal;

import java.util.*;
import java.util.stream.Collectors;

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

    public HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> values = null;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        values = new HashMap<>();
        final LinkedList<List<Integer>> result = new LinkedList<>();
        int[] range = traverse(root, 0,0);
        for(int i=range[0]; i<=range[1]; i++) {
            result.add(new ArrayList<>());
            List<ArrayList<Integer>> byRowVals = values.get(i).entrySet().stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getKey))
                    .map(Map.Entry::getValue).toList();
            for(ArrayList<Integer> sameRow: byRowVals){
                if(sameRow.size()==0) result.getLast().add(sameRow.get(0));
                else {
                    Integer[] sameRowVals = new Integer[sameRow.size()];
                    sameRow.toArray(sameRowVals);
                    Arrays.sort(sameRowVals);
                    result.getLast().addAll(Arrays.stream(sameRowVals).toList());
                }
            }
        }
        return result;
    }

    public int[] traverse(TreeNode root, int row, int col) {
        if(root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        values.putIfAbsent(col, new HashMap<>());
        values.get(col).putIfAbsent(row, new ArrayList<>());
        values.get(col).get(row).add(root.val);
        int[] left = traverse(root.left, row+1, col-1);
        int[] right = traverse(root.right, row+1, col+1);
        int[] child = new int[] {Math.min(left[0], right[0]), Math.max(left[1], right[1])};
        return new int[]{Math.min(col, child[0]), Math.max(col, child[1])};
    }
}
