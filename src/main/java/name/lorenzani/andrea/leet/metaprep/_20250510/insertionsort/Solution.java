package name.lorenzani.andrea.leet.metaprep._20250510.insertionsort;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(head.val);
        ListNode iter = head.next;
        while(iter!=null){
            ListNode prev=null;
            ListNode succ=sorted;
            while(succ!=null && succ.val< iter.val) {
                prev = succ;
                succ = succ.next;
            }
            ListNode newElem = new ListNode(iter.val);
            if(prev==null) sorted = newElem;
            else prev.next = newElem;
            newElem.next = succ;
            iter = iter.next;
        }
        return sorted;
    }
}
