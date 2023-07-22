package name.lorenzani.andrea.leet.leet_2;

import junit.framework.TestCase;
import name.lorenzani.andrea.leet.leet_2.ListNode;
import name.lorenzani.andrea.leet.leet_2.Solution;

public class SolutionTest extends TestCase {

    public void testAddTwoNumbers() {
        ListNode first = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode second = new ListNode(9, new ListNode(9));
        ListNode res = Solution.addTwoNumbers(first, second);
        System.out.println("WOW");
    }
}