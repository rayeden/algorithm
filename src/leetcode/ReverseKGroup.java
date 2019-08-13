package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/24
 * @description
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ReverseKGroup rkg = new ReverseKGroup();
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i < 12; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        ListNode result = rkg.reverseKGroup(head, 3);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode[] list = new ListNode[k];
        ListNode tmp = head;
        ListNode newHead = null, tail = null;
        while (tmp != null) {
            int i = 0;
            for (; i < k && tmp != null; i++) {
                list[i] = tmp;
                tmp = tmp.next;
            }
            if (i == k) {
                for (int j = k - 1; j > 0; j--) {
                    list[j].next = list[j - 1];
                }
                if (null == newHead) {
                    newHead = list[k - 1];
                    tail = list[0];
                } else {
                    tail.next = list[k - 1];
                    tail = list[0];
                }
            } else {
                if (null == newHead) {
                    return head;
                } else {
                    tail.next = list[0];
                    tail = list[i - 1];
                }
            }
            tail.next = null;
        }
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
