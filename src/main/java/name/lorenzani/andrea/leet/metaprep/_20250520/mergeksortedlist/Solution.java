package name.lorenzani.andrea.leet.metaprep._20250520.mergeksortedlist;

import java.util.ArrayList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode mergeKListsInefficient(ListNode[] lists) {
        ListNode result = null, pointer = null;
        int min = nextMin(lists);
        while(min>-1) {
            if(result == null) {
                result = new ListNode(lists[min].val);
                pointer = result;
            }
            else {
                pointer.next = new ListNode(lists[min].val);
                pointer = pointer.next;
            }
            lists[min] = lists[min].next;
            min = nextMin(lists);
        }
        return result;
    }

    protected int nextMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i=0; i< lists.length; i++) {
            if(lists[i]==null) continue;
            if(lists[i].val < min) {
                pos = i;
                min = lists[i].val;
            }
        }
        return pos;
    }

}
