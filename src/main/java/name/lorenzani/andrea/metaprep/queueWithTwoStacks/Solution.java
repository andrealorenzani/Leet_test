package name.lorenzani.andrea.metaprep.queueWithTwoStacks;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> head = new Stack<>();
        Stack<Integer> tail = new Stack<>();

        Scanner scan = new Scanner(System.in);
        int queries = scan.nextInt();
        for(int i=0; i<queries; i++) {
            int queryType = scan.nextInt();
            if(queryType == 1) {
                int data = scan.nextInt();
                tail.push(data);
            }
            else if(queryType == 2) {
                invertStack(tail, head);
                head.pop();
            }
            else if(queryType == 3) {
                invertStack(tail, head);
                System.out.println(head.peek());
            }
        }
    }

    private static void invertStack(Stack<Integer> from, Stack<Integer> to) {
        if(to.size()>0) return;
        while(from.size()>0){
            to.push(from.pop());
        }
    }

}
