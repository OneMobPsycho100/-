package t3_linkedlist;

/**
 * AddTwoNumbersCode05
 *
 * @author cmz
 * @date 2021-05-31 22:19
 */
public class AddTwoNumbersCode05 {

    public static class ListNode {
        public int val;

        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = getListNodeLength(l1);
        int l2Length = getListNodeLength(l2);
        ListNode headLong = l1Length > l2Length ? l1 : l2;
        ListNode headShort = headLong == l1 ? l2 : l1;
        ListNode curLong = headLong;
        ListNode last = headLong;
        int carry = 0;
        while (headShort != null) {
            int sum = curLong.val + headShort.val + carry;
            curLong.val = sum % 10;
            carry = sum / 10;
            last = curLong;
            curLong = curLong.next;
            headShort = headShort.next;
        }

        while (curLong != null) {
            int sum = curLong.val + carry;
            curLong.val = sum % 10;
            carry = sum / 10;
            last = curLong;
            curLong = curLong.next;
        }
        last.next = carry > 0 ? new ListNode(carry) : null;
        return headLong;
    }

    public static int getListNodeLength(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
