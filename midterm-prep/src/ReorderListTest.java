

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReorderListTest {


    @Test
    public void testReorderEvenNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReorderList rl = new ReorderList();
        rl.reorderList(head);

        int[] expected = {1, 6, 2, 5, 3, 4};
        ListNode curr = head;
        for (int val : expected) {
            Assertions.assertEquals(val, curr.val);
            curr = curr.next;
        }
    }
    @Test

    public void testReorderOddNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList rl = new ReorderList();
        rl.reorderList(head);

        int[] expected = {1, 5, 2, 4, 3};
        ListNode curr = head;
        for (int val : expected) {
            Assertions.assertEquals(val, curr.val);
            curr = curr.next;
        }
    }
}
