package leetcode;

/**
 * @author Sesame
 * @createTime 2019/7/19
 * @description
 */
public class CopyRandomList {

    public static void main(String[] args) {
        CopyRandomList cr = new CopyRandomList();
        Node head = new Node(1, null, null);
        Node node = new Node(2, null, null);
        head.next = node;
        head.random = node;
        node.random = node;

        Node res = cr.copyRandomList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val, temp.next, null);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node newHead = head.next;
        temp = newHead;
        while(temp != null && temp.next != null){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return newHead;
    }

}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
