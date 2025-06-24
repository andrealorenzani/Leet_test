package name.lorenzani.andrea.leet.metaprep._20250513.kclosestpointtoorigin;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> distances = new PriorityQueue<>((x,y) -> (int) (y.distance-x.distance));
        for(int[] point : points) {
            Distance curr = new Distance(point[0], point[1]);
            if(distances.size()<k || distances.peek().distance > curr.distance){
                distances.add(curr);
            }
            if(distances.size()>k) distances.poll();
        }
        final int[][] res = new int[distances.size()][2];
        AtomicInteger pos = new AtomicInteger(0);
        distances.stream().map(dist -> new int[]{dist.x, dist.y}).forEach(val -> res[pos.getAndIncrement()] = val);
        return res;
    }

}

class Distance {
    int x,y;
    double distance;
    public Distance(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = distance(x,y);
    }

    double distance(int x, int y){
        return Math.pow(x, 2)+Math.pow(y,2);
    }
}
