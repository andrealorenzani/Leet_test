package name.lorenzani.andrea.leet.metaprep._20250527.clonegraph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> cloned = new HashMap<>();
        Queue<Node> tbv = new LinkedList<>();
        tbv.add(node);
        cloned.put(node, new Node(node.val));
        while(!tbv.isEmpty()) {
            Node visiting = tbv.poll();
            for(Node neighbour : visiting.neighbors) {
                if(!cloned.containsKey(neighbour)) tbv.add(neighbour);
                cloned.putIfAbsent(neighbour, new Node(neighbour.val));
                cloned.get(visiting).neighbors.add(cloned.get(neighbour));
            }
        }
        return cloned.get(node);
    }
}
