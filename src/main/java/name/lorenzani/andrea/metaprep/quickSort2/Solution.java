package name.lorenzani.andrea.metaprep.quickSort2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static void quickSortV1(int[] ar) {
        if(ar.length<=1) return;
        final List<Integer> theValue = new ArrayList<>(ar.length);
        Arrays.stream(ar).boxed().forEach(elem -> theValue.add(elem));
        quickSortImpl(theValue);
        for(int i=0; i<theValue.size(); i++) {
            ar[i] = theValue.get(i);
        }
    }

    static void quickSort(int[] ar) {
        if(ar.length<=1) return;
        if(ar.length==2 && ar[1]<ar[0]) {
            int tmp = ar[0];
            ar[0] = ar[1];
            ar[1] = tmp;
        }
        int[] lower = new int[ar.length];
        int posLower=0;
        int[] greater = new int[ar.length];
        int posGreater = 0;
        int pivot = ar[0];
        for(int i=1; i<ar.length; i++) {
            if(ar[i]<ar[0]) {
                lower[posLower] = ar[i];
                posLower++;
            }
            else {
                greater[posGreater] = ar[i];
                posGreater++;
            }
        }
        lower = Arrays.copyOfRange(lower, 0, posLower);
        greater = Arrays.copyOfRange(greater, 0, posGreater);
        quickSort(lower);
        quickSort(greater);
        for(int i=0; i<ar.length; i++){
            if(i<lower.length) ar[i]=lower[i];
            else if(i==lower.length) ar[i] = pivot;
            else ar[i] = greater[i-lower.length-1];
        }
        printArray(ar);
    }

    static void quickSortImpl(List<Integer> arr) {
        if(arr.size()<2) return;
        if(arr.size() == 2) {
            if(arr.get(1) < arr.get(0)) {
                int tmp = arr.get(0);
                arr.set(0, arr.get(1));
                arr.set(1, tmp);
            }
        }
        else {
            int pivot = arr.get(0);
            List<Integer> lower = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for(int i=1; i<arr.size(); i++) {
                if(arr.get(i)>pivot) greater.add(arr.get(i));
                else lower.add(arr.get(i));
            }
            quickSortImpl(lower);
            quickSortImpl(greater);
            arr.clear();
            arr.addAll(lower);
            arr.add(pivot);
            arr.addAll(greater);
        }
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i) + ((i==arr.size()-1)? "" : " "));
        }
        System.out.println();

    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }
}
