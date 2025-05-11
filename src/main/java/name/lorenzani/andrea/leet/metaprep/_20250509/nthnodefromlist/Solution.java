package name.lorenzani.andrea.leet.metaprep._20250509.nthnodefromlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list. */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
    public ListNode removeNthFromEndWithStack(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode iter = head;
        while(iter!=null){
            stack.push(iter);
            iter = iter.next;
        }
        for(int i=0; i<n;i++) {
            iter = stack.pop();
        }
        if(iter!=head) {
            ListNode prev = stack.pop();
            prev.next = iter.next;
            return head;
        }
        else {
            return iter.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = head;
        ListNode tbd = head;
        ListNode prev = head;
        for(int i=0; i<n; i++) {
            iter = iter.next;
        }
        while(iter!=null) {
            iter = iter.next;
            prev = tbd;
            tbd = tbd.next;
        }
        if(tbd==head){
            return head.next;
        }
        else {
            prev.next = tbd.next;
            return head;
        }
    }
}
