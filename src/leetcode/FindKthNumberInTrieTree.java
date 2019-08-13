package leetcode;

/**
 * @author Sesame
 * @createTime 2019/7/18
 * @description
 */
public class FindKthNumberInTrieTree {

    public static void main(String[] args) {
        FindKthNumberInTrieTree fk = new FindKthNumberInTrieTree();
        System.out.println(fk.findKthNumber(13, 11));
    }

    int findKthNumber(int n, int k) {
        int cur = 1;
        --k;
        while (k > 0) {
            long first = cur, last = cur + 1, step = 0;
            while (first <= n) {
                step += Math.min((long) n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            if (step <= k) {
                k -= step;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

}
