package name.lorenzani.andrea.leet.maximisescore;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    ArrayList<Integer> primes;
    Map<Integer, Long> valuesToPrime;

    public int maximumScore(List<Integer> nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> highest = new PriorityQueue<>((a,b) -> Integer.compare(b.getKey(), a.getKey()));
        int[] val = new int[nums.size()];
        int pos = 0;
        for(int j:nums){
            val[pos]=j;
            highest.add(Map.entry(j, pos));
            pos++;
        }
        initPrimes(highest.peek().getKey());
        valuesToPrime = new HashMap<>();
        pos = -1;
        //BigInteger total = BigInteger.ONE;
        long total = 1;
        for(int j=0; j<k;) {
            pos=highest.poll().getValue();
            double tmp = Math.min(computeIteration(val, pos), k-j);
            for(int i=0; i<tmp; i++) {
                total = (total * val[pos])%1000000007;
            }
            //total = total.multiply(BigInteger.valueOf((long)Math.pow(val[pos], tmp)));
            j += tmp;
        }
        //return total.mod(BigInteger.valueOf(1000000007)).intValue();
        return (int)total;
    }

    public void initPrimes(int val){
        primes = new ArrayList<>();
        for(int i=2; i<=val; i++){
            boolean isPrime = true;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j!=0) continue;
                else {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(i);
        }
    }

    public double computeIteration(int[] values, int pos) {
        valuesToPrime.putIfAbsent(values[pos],primeScore(values[pos]));
        long posPS = valuesToPrime.get(values[pos]);
        int start = pos-1;
        int end = pos+1;
        for(; start>=0; start--) {
            valuesToPrime.putIfAbsent(values[start],primeScore(values[start]));
            if(valuesToPrime.get(values[start])>=posPS){
                break;
            }
        }
        for(; end<= values.length-1; end++) {
            valuesToPrime.putIfAbsent(values[end],primeScore(values[end]));
            if(valuesToPrime.get(values[end])>posPS){
                break;
            }
        }
        return (end-pos)*(pos-start);
    }

    public long primeScore(int value) {
        return primes.stream()
                .filter(n -> value%n==0)
                .count();
    }

}
