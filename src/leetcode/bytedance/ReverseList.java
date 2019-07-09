package leetcode.bytedance;

/**
 * @author Sesame
 * @createTime 2019/7/7
 * @description
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ReverseList rl = new ReverseList();
        ListNode newHead = rl.reverseList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

