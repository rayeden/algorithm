package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sesame
 * @createTime 2019/7/16
 * @description
 */
public class IsPalindrome {

    public boolean isPalindrome2(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Deque<Integer> deque = new LinkedList<>();
        while (x > 0) {
            deque.add(x % 10);
            x /= 10;
        }
        while (!deque.isEmpty()) {
            Integer first = deque.pollFirst();
            Integer last = deque.pollLast();
            if (null != last && !first.equals(last)) {
                return false;
            }
        }
        return true;
    }
}
