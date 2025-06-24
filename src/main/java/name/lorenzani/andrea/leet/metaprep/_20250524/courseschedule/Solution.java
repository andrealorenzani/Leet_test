package name.lorenzani.andrea.leet.metaprep._20250524.courseschedule;

import java.util.*;

class Node {
    int course;
    ArrayList<Node> neededFor;
    boolean visited;

    public Node(int course) {
        neededFor = new ArrayList<>();
        this.course = course;
        visited = false;
    }

    public void prerequisite(Node toObtain) {
        neededFor.add(toObtain);
    }
}

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> courseToNode = new HashMap<>();
        Queue<Node> toBeVisited = new LinkedList<>();
        for(int i=0; i< prerequisites.length; i++) {
            courseToNode.putIfAbsent(prerequisites[i][0], new Node(prerequisites[i][0]));
            courseToNode.putIfAbsent(prerequisites[i][1], new Node(prerequisites[i][1]));
            courseToNode.get(prerequisites[i][1]).prerequisite(courseToNode.get(prerequisites[i][0]));
            toBeVisited.add(courseToNode.get(prerequisites[i][1]));
        }
        Node tbv = toBeVisited.poll();
        while(tbv!=null){
            if(tbv.visited) {
                tbv = toBeVisited.poll();
                continue;
            }
            boolean hasLoop = checkLoops(tbv, new HashSet<Node>());
            if(hasLoop) return false;
            tbv = toBeVisited.poll();
        }
        return true;
    }

    public boolean checkLoops(Node visiting, HashSet<Node> parents) {
        if(parents.contains(visiting)) {
            return true;
        }
        if(visiting.visited) return false;
        parents.add(visiting);
        visiting.visited = true;
        for(Node child: visiting.neededFor) {
            if(checkLoops(child, parents)) return true;
        }
        parents.remove(visiting);
        return false;
    }

}
