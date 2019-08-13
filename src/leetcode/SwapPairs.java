package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/28
 * @description
 */
public class SwapPairs {

    public static void main(String[] args) {
        SwapPairs sp = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode newHead = sp.swapPairs(head);
        while (null != newHead) {
            System.out.println(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, first = head, second = head.next;
        ListNode newHead = null;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            if (null != prev) {
                prev.next = second;
            }
            prev = first;
            if (null == newHead) {
                newHead = second;
            }
            first = first.next;
            if (null != first) {
                second = first.next;
            }
        }
        return newHead;
    }
}
