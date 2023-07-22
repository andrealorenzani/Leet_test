package name.lorenzani.andrea.leet.leet_2;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int prev = 0;
        ListNode top = l1;
        ListNode bottom = l2;
        ListNode result = new ListNode(0);
        ListNode prevNode = null;
        while(top != null || bottom != null) {
            int a = 0;
            if(top != null) {
                a = top.val;
                top = top.next;
            }
            int b = 0;
            if(bottom != null) {
                b = bottom.val;
                bottom = bottom.next;
            }
            if(prevNode == null) {
                result = new ListNode((a+b+prev)%10);
                prevNode = result;
            }
            else {
                prevNode.next = new ListNode((a+b+prev)%10);
                prevNode = prevNode.next;
            }
            prev = (a+b+prev)/10;
        }
        if(prev > 0) prevNode.next = new ListNode(prev);
        return result;
    }
}
