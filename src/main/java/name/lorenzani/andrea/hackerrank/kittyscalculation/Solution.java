package name.lorenzani.andrea.hackerrank.kittyscalculation;

import java.util.*;

class Node{
    int data;
    List<Node> adiacNodes = new ArrayList<Node>();
    public Node(int data) {
        this.data = data;
    }

    public void connect(Node adiacent) {
        this.adiacNodes.add(adiacent);
        adiacent.adiacNodes.add(this);
    }
}

public class Solution {


    static HashMap<Integer, Node> ref = new HashMap<>();
    static long[][] dists;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numNodes = scan.nextInt();
        int numQueryNodes = scan.nextInt();
        for(int i=0; i<numNodes-1; i++){
            int first = scan.nextInt();
            ref.putIfAbsent(first, new Node(first));
            int second = scan.nextInt();
            ref.putIfAbsent(second, new Node(second));
            ref.get(first).connect(ref.get(second));
        }
        dists =  new long[ref.size()+1][ref.size()+1];
        for (int i=0; i<numQueryNodes; i++){
            int nodesToRead = scan.nextInt();
            int[] nodes = new int[nodesToRead];
            for(int j=0; j<nodesToRead; j++) {
                nodes[j] = scan.nextInt();
            }
            computeQuery(nodes);
        }
    }

    public static void computeQuery(int[] nodes){
        long result = 0;
        for(int i=0; i<nodes.length-1; i++) {
            for(int j=i+1; j<nodes.length; j++) {
                if(dists[nodes[i]][nodes [j]]==0) {
                    dist(nodes[i]);
                }
                result += nodes[i] * nodes [j] * dists[nodes[i]][nodes [j]];
                result = result % 1000000007;
            }
        }
        System.out.println(result % 1000000007);
    }

    public static void dist(int start) {
        LinkedList<Node> toVisit = new LinkedList<>();
        toVisit.add(ref.get(start));
        dists[start][start] = 0;
        while(!toVisit.isEmpty()) {
            Node curr = toVisit.pollFirst();
            long distFromStart = dists[start][curr.data];
            for(Node adiac: curr.adiacNodes) {
                if(dists[start][adiac.data]==0 && start != adiac.data) {
                    toVisit.add(adiac);
                    dists[start][adiac.data] = distFromStart+1;
                    dists[adiac.data][start] = distFromStart+1;
                }
            }
        }
    }
}
