package name.lorenzani.andrea.leet.interview150.TwoSum2;

public class Solution {
    public int[] twoSum_working(int[] numbers, int target) {
        for(int i=0; i < numbers.length; i++) {
            int result = binarySearch(numbers, target-numbers[i], i+1, numbers.length);
            if(result > -1) return new int[]{i+1, result+1};
        }
        return numbers;
    }

    public int[] twoSum(int[] numbers, int target) {
        int maxIdx = numbers.length;
        for(int i=0; i < numbers.length; i++) {
            int[] result = binarySearchWithMax(numbers, target-numbers[i], i+1, maxIdx);
            if(result[0] > -1) return new int[]{i+1, result[0]+1};
            maxIdx = result[1];
        }
        return numbers;
    }

    public int[] binarySearchWithMax(int[] numbers, int target, int start, int end) {
        System.out.println(String.format("Searching %d from %d to %d", target, start, end));
        int pivot = start+((end-start)/2);
        if(pivot> numbers.length-1 || pivot < 0) return new int[]{-1, end};
        else if(numbers[pivot]==target) return new int[]{pivot, pivot};
        else if(start>=end) return new int[]{-1, Math.max(start, end)};
        else if(numbers[pivot]<target) return binarySearchWithMax(numbers, target, pivot+1, end);
        else if(numbers[pivot]>target) return binarySearchWithMax(numbers, target, start, pivot-1);
        else return new int[]{-1, end};
    }

    public int binarySearch(int[] numbers, int target, int start, int end) {
        System.out.println(String.format("Searching %d from %d to %d", target, start, end));
        int pivot = start+((end-start)/2);
        if(pivot> numbers.length-1 || pivot < 0) return -1;
        else if(numbers[pivot]==target) return pivot;
        else if(start>=end) return -1;
        else if(numbers[pivot]<target) return binarySearch(numbers, target, pivot+1, end);
        else if(numbers[pivot]>target) return binarySearch(numbers, target, start, pivot-1);
        else return -1;
    }
}
