package name.lorenzani.andrea.metaprep.snakesLadders;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        HashMap<Integer, Integer> transport = new HashMap<>(ladders.size()+snakes.size());
        HashMap<Integer, Integer> steps = new HashMap<>(100);
        for(List<Integer> snake: snakes) {
            transport.put(snake.get(0), snake.get(1));
        }
        for(List<Integer> ladder: ladders) {
            transport.put(ladder.get(0), ladder.get(1));
        }
        LinkedList<Integer> toVisit = new LinkedList<>();
        toVisit.add(1);
        steps.put(1,0);
        while(toVisit.size()!=0) {
            int curr = toVisit.pollFirst();
            for(int i=1; i<=6; i++) {
                if(curr+i == 100) return steps.get(curr)+1;
                Integer to = transport.get(curr+i);
                if(to!=null){
                    if(steps.get(to)==null || steps.get(to)>steps.get(curr)+1) {
                        if(to==100) return steps.get(curr)+1;
                        toVisit.add(to);
                        steps.put(to, steps.get(curr)+1);
                    }
                }
                else {
                    Integer value = steps.get(curr + i);
                    if (value == null || value > steps.get(curr) + 1) {
                        steps.put(curr + i, steps.get(curr) + 1);
                        toVisit.add(curr+i);
                    }
                }
            }
        }
        return -1;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
