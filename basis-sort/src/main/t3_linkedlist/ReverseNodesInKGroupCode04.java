package t3_linkedlist;

/**
 * ReverseNodesInKGroup
 *
 * @author cmz
 * @date 2021-05-30 22:26
 */
public class ReverseNodesInKGroupCode04 {

    public static class ListNode {
        public int val;
        public ListNode next;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = head;
        ListNode end = getGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }


    public static ListNode getGroupEnd(ListNode start, int k) {

        while (start != null && --k != 0) {
            start = start.next;
        }

        return start;
    }

    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

}
