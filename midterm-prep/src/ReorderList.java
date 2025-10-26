class ListNode {
    int val; ListNode next;
    ListNode(int x) { val = x; }
}

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) find middle (end of first half)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) reverse second half
        ListNode second = slow.next;
        slow.next = null;          // split
        second = reverseList(second);

        // 3) merge
        mergeLists(head, second);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;

            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
    }
}
