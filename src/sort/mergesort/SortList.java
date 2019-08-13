package sort.mergesort;

/**
 * @author Sesame
 * @createTime 2019/7/19
 * @description
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(3);

        SortList sl = new SortList();
        ListNode res = sl.sortList(head.next);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstList = head;
        ListNode secondList = slow.next;
        slow.next = null;
        ListNode left = sortList(firstList);
        ListNode right = sortList(secondList);

        ListNode res = mergeSort(left, right);

        return res;
    }

    public ListNode mergeSort(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}