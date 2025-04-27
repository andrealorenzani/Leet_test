package name.lorenzani.andrea.metaprep.qheap1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    static PriorityQueue<Integer> heap;

    public static void main(String[] args) {
        heap = new PriorityQueue<>();
        Scanner scan = new Scanner(System.in);
        int queries = scan.nextInt();
        for(int i=0; i<queries; i++) {
            int queryType = scan.nextInt();
            switch(queryType) {
                case 1:
                    insert(scan.nextInt());
                    break;
                case 2:
                    delete(scan.nextInt());
                    break;
                case 3:
                    print(heap.peek());
            }
        }
    }

    static void insert(int val) {
        heap.add(val);
    }
    static void delete(int val) {
        heap.remove(val);
    }
    static void print(int val) {
        System.out.println(val);
    }
}
