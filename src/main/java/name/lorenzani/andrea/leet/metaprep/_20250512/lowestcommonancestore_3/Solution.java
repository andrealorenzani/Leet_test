package name.lorenzani.andrea.leet.metaprep._20250512.lowestcommonancestore_3;

import java.util.HashSet;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

public class Solution {

    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> ancestors = new HashSet<>();
        while(p!=null){
            if(p==q) return q;
            ancestors.add(p);
            p=p.parent;
        }
        while(q!=null) {
            if(ancestors.contains(q)) return q;
            q=q.parent;
        }
        return null;
    }

}
