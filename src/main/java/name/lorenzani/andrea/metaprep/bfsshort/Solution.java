package name.lorenzani.andrea.metaprep.bfsshort;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node {
    public HashSet<Node> connections;
    public int data;
    public boolean visited;

    public Node(int data){
        this.data = data;
        connections = new HashSet<Node>();
        visited = false;
    }

    public void connect(Node to) {
        this.connections.add(to);
        to.connections.add(this);
    }
}

class Result {



    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n number of nodes
     *  2. INTEGER m number of edges
     *  3. 2D_INTEGER_ARRAY edges[m][2] start and stop
     *  4. INTEGER s the start node
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Node start = initGraph(edges, s);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            result.add(-1);
        }
        result.set(start.data-1, 0);
        LinkedList<Node> toVisit = new LinkedList<>();
        toVisit.add(start);
        bfs(result, toVisit);
        result.remove(start.data-1);
        return result;
    }

    private static void bfs(final List<Integer> values, final LinkedList<Node> toVisit){
        Node curr = toVisit.pollFirst();
        if(curr != null) {
            curr.connections.forEach(node -> {
                if(!node.visited){
                    node.visited = true;
                    values.set(node.data-1, values.get(curr.data-1)+6);
                    toVisit.addLast(node);
                }
            });
            bfs(values, toVisit);
        }
    }

    private static Node initGraph(List<List<Integer>> edges, int s) {
        HashMap<Integer, Node> tmp = new HashMap<>();
        for(List<Integer> edge: edges){
            tmp.putIfAbsent(edge.get(0), new Node(edge.get(0)));
            tmp.putIfAbsent(edge.get(1), new Node(edge.get(1)));
            tmp.get(edge.get(0)).connect(tmp.get(edge.get(1)));
        }
        return tmp.get(s);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

