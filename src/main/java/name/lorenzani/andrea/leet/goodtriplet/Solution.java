package name.lorenzani.andrea.leet.goodtriplet;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int total =0;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=i+1; j<arr.length-1; j++){
                if(Math.abs(arr[i]-arr[j])>a) continue;
                for(int k=j+1; k<arr.length; k++) {
                    if(Math.abs(arr[j]-arr[k])<=b &&
                    Math.abs(arr[i]-arr[k]) <= c) {
                        total++;
                    }
                }
            }
        }
        return total;
    }


    public int countGoodTriplets_maps(int[] arr, int a, int b, int c) {
        TreeMap<Integer, List<Integer>> values = new TreeMap<>();
        int total = 0;
        for (int i=0; i<arr.length; i++) {
            if(!values.containsKey(arr[i])) {
                values.put(arr[i], new ArrayList<>());
            }
            values.get(arr[i]).add(i);
        }
        for (int i=0; i<arr.length; i++) {
            final int arrVal = arr[i];
            final int idx = i;
            // We know that arr[j] >= arr[i]-a and arr[j]<=arr[i]+a
            total += values.headMap(a+arr[i], true).entrySet()
                    .stream().filter( x -> x.getKey() >= arrVal - a)
                    .flatMap(bEntry -> {
                        // We filter by index
                        return bEntry.getValue().stream()
                                .filter(bidx -> bidx > idx)
                                .flatMap(bidx -> {
                                    // We know that arr[k] >= arr[j]-b and arr[k] <= arr[j] + b
                                    return values.headMap(bEntry.getKey()+b, true).entrySet()
                                            .stream().filter( x -> x.getKey() >= bEntry.getKey() - b)
                                            .filter(x -> Math.abs(arrVal - x.getKey()) <= c)
                                            .flatMap(cEntry -> {
                                                // We filter by index
                                                return cEntry.getValue().stream()
                                                        .filter(cidx -> cidx>bidx)
                                                        .map(cidx -> Map.entry(bidx, cidx));
                                            });
                                });
                    }).count();
        }
        return total;
    }

}
