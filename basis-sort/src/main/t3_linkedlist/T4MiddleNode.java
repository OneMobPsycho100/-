package t3_linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * T4MiddleNode
 *
 * @author cmz
 * @date 2021-06-08 22:55
 */
public class T4MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, ListNode> map = new HashMap<>();
        int len = 1;
        while (head != null) {
            map.put(len++, head);
            head = head.next;
        }

        if (len % 2 != 0) {
            return map.get(len / 2);
        } else {
            return map.get(len / 2 + 1);
        }

    }


}
