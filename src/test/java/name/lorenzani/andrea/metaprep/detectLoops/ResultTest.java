package name.lorenzani.andrea.metaprep.detectLoops;

import junit.framework.TestCase;
import org.junit.Assert;

public class ResultTest extends TestCase {

    public void testBasicCases() {
        Result res = new Result();

        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
        head.next.next.next = head.next;

        Assert.assertTrue(Result.hasCycle(head));

    }

}