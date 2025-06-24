package name.lorenzani.andrea.leet.metaprep._20250528.slidingwindowmedian;

import java.util.*;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();
        int balance = 0;
        HashMap<Integer, Integer> toBeRemoved = new HashMap<>();
        int start = k/2;
        boolean needsNext = k%2==0;
        double[] res = new double[nums.length-k+1];

        for(int i=0; i<k-1; i++) {
            balance = addToSliding(low, high, toBeRemoved, balance, nums[i]);
        }
        for(int i=k-1; i< nums.length; i++){
            if(i-k+1>0) {
                int tbr = nums[i-k];
                balance = removeToSliding(low, high, toBeRemoved, balance, tbr);
            }
            balance = addToSliding(low, high, toBeRemoved, balance, nums[i]);
            if(!needsNext) res[i-k+1] = (balance==-1)? low.peek(): high.peek();
            else {
                if(balance==0) res[i-k+1] = ((double)low.peek() + (double)high.peek())/2d;
                else {
                    int val2 = low.poll();
                    res[i-k+1] = ((double)low.peek() + (double)val2)/2d;
                    low.add(val2);
                }
            }
        }
        return res;
    }

    private int addToSliding(PriorityQueue<Integer> low, PriorityQueue<Integer> high, HashMap<Integer, Integer> tbr, int balance, int val) {
        if(low.isEmpty() || low.peek()>=val) {
            balance--;
            low.add(val);
        }
        else {
            high.add(val);
            balance++;
        }
        return rebalance(low, high, tbr, balance);
    }

    private int rebalance(PriorityQueue<Integer> low, PriorityQueue<Integer> high, HashMap<Integer, Integer> tbr, int balance) {
        while(balance<-1) {
            high.add(low.poll());
            balance += 2;
        }
        while(balance>0) {
            low.add(high.poll());
            balance -= 2;
        }
        while(tbr.containsKey(low.peek())) {
            int curr = low.poll();
            tbr.put(curr, tbr.get(curr)-1);
            if(tbr.get(curr)==0) tbr.remove(curr);
        }
        while(tbr.containsKey(high.peek())) {
            int curr = high.poll();
            tbr.put(curr, tbr.get(curr)-1);
            if(tbr.get(curr)==0) tbr.remove(curr);
        }
        return balance;
    }
    private int removeToSliding(PriorityQueue<Integer> low, PriorityQueue<Integer> high, HashMap<Integer, Integer> tbr, int balance, int val) {
        if(val <= low.peek()) {
            if(val == low.peek()) {
                low.poll();
            }
            else {
                tbr.put(val, tbr.getOrDefault(val, 0)+1);
            }
            balance++;
        }
        else {
            if(val == high.peek()) {
                high.poll();
            }
            else {
                tbr.put(val, tbr.getOrDefault(val, 0)+1);
            }
            balance--;
        }
        return rebalance(low, high, tbr, balance);
    }

    public double[] medianSlidingWindowSlow(int[] nums, int k) {
        TreeSet<Integer> sliding = new TreeSet<>();
        HashMap<Integer, Integer> occ = new HashMap<>();
        int start = k/2;
        boolean needsNext = k%2==0;
        double[] res = new double[nums.length-k+1];
        for(int i=0; i<k-1; i++) {
            addToSliding(sliding, occ, nums[i]);
        }
        for(int i=k-1; i< nums.length; i++) {
            addToSliding(sliding, occ, nums[i]);
            if(i!=k-1) removeToSliding(sliding, occ, nums[i-k]);
            Iterator<Integer> iter = sliding.iterator();
            int iterNum = start;
            int val = 0;
            while(iter.hasNext() && iterNum>0){
                val = iter.next();
                iterNum -= occ.get(val);
            }
            if(needsNext) {
                if(iterNum<0) res[i-k+1] = val;
                else res[i-k+1] = (((double)val) + ((double)iter.next()))/2D;
            }
            else {
                if(iterNum<0) res[i-k+1] = val;
                else res[i-k+1] = iter.next();
            }
        }
        return res;
    }

    private void addToSliding(TreeSet<Integer> sliding, HashMap<Integer, Integer> occ, int value) {
        if(!occ.containsKey(value)) {
            sliding.add(value);
            occ.put(value, 1);
        }
        else {
            occ.put(value, occ.get(value)+1);
        }
    }
    private void removeToSliding(TreeSet<Integer> sliding, HashMap<Integer, Integer> occ, int value) {
        if(occ.get(value) == 1) {
            sliding.remove(value);
            occ.remove(value);
        }
        else {
            occ.put(value, occ.get(value)-1);
        }
    }

    public double[] medianSlidingWindowNotUnderstood(int[] nums, int k) {
        int start = 0;
        int end = 0;
        if(k%2==0) {
            start = (k/2)-1;
            end = start+1;
        }
        else {
            start = k/2;
            end = k/2;
        }
        double[] res = new double[nums.length-k+1];
        for(int i=k-1; i<nums.length; i++) {
            res[i-k+1] = (((double) nums[start]) + ((double)nums[end]))/2D;
            start++; end++;
        }
        return res;
    }
}
