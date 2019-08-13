package leetcode;

/**
 * @author BG289522
 * @createTime 2019/8/3
 * @description
 */
public class ReverseList {

    private static ListNode newHead = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);

        ReverseList rl = new ReverseList();
        rl.reverse(head, null);
        while (newHead != null) {
            System.out.println(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    private void reverse(ListNode node, ListNode prev) {
        if (node.next != null) {
            reverse(node.next, node);
        }
        if (null == newHead) {
            newHead = node;
        }
        node.next = prev;
    }
}
