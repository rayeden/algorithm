package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/28
 * @description
 */
public class IsLinkedListPalindrome {

    public static void main(String[] args) {

        System.out.println(5 >> 1);
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int[] arr = {1, 2};
        for (int a : arr) {
            tail.next = new ListNode(a);
            tail = tail.next;
        }
        tail.next = null;

        IsLinkedListPalindrome il = new IsLinkedListPalindrome(head.next);
        System.out.println(il.isPalindrome(head.next));
    }

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode tail = head;
        return isPalindromeCore(tail, true);
    }

    private ListNode head;

    public IsLinkedListPalindrome(ListNode head) {
        this.head = head;
    }

    public boolean isPalindromeCore(ListNode tail, Boolean flag) {
        if (tail.next != null) {
            flag = isPalindromeCore(tail.next, flag);
            if (!flag) {
                return false;
            }
        }
        if (tail.val != head.val) {
            return false;
        }
        head = head.next;
        return true;
    }
}
