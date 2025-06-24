package name.lorenzani.andrea.leet.metaprep._20250524.insertintosortedcircular;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest extends TestCase {

    public void testAfterMax() {
        Solution s = new Solution();

        Node start = new Node(0);
        start.next = new Node(1, new Node(2, new Node(3, new Node(4, start))));

        Node result = s.insert(start.next, 5);
        Node pointer = result.next;
        ArrayList<Integer> resultInArray = new ArrayList<>(6);
        while(pointer != result) {
            resultInArray.add(pointer.val);
            pointer = pointer.next;
        }
        resultInArray.add(pointer.val);
        assertEquals(List.of(2,3,4,5,0,1), resultInArray);
    }

    public void testBeforeMin() {
        Solution s = new Solution();

        Node start = new Node(0);
        start.next = new Node(1, new Node(2, new Node(3, new Node(4, start))));

        Node result = s.insert(start.next, -1);
        Node pointer = result.next;
        ArrayList<Integer> resultInArray = new ArrayList<>(6);
        while(pointer != result) {
            resultInArray.add(pointer.val);
            pointer = pointer.next;
        }
        resultInArray.add(pointer.val);
        assertEquals(List.of(2,3,4,-1,0,1), resultInArray);
    }

    public void testNotWorking() {
        Solution s = new Solution();

        Node start = new Node(3);
        start.next = new Node(3, new Node(5, start));

        Node result = s.insert(start, 0);
        Node pointer = result.next;
        ArrayList<Integer> resultInArray = new ArrayList<>(6);
        while(pointer != result) {
            resultInArray.add(pointer.val);
            pointer = pointer.next;
        }
        resultInArray.add(pointer.val);
        assertEquals(List.of(3,5,0,3), resultInArray);
    }

    public void testNotWorking2() {
        Solution s = new Solution();

        Node start = new Node(3);
        start.next = new Node(3, new Node(3, start));

        Node result = s.insert(start, 0);
        Node pointer = result.next;
        ArrayList<Integer> resultInArray = new ArrayList<>(6);
        while(pointer != result) {
            resultInArray.add(pointer.val);
            pointer = pointer.next;
        }
        resultInArray.add(pointer.val);
        assertEquals(List.of(0,3,3,3), resultInArray);
    }

}