package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sesame
 * @createTime 2019/7/12
 * @description
 */
public class FindKthLargest {

    private static PriorityQueue<Integer> pq = new PriorityQueue<>(1, (o1, o2) -> 0);


    public static void main(String[] args) {
        FindKthLargest fk = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(fk.findKthLargest(nums, 2));

    }

    public int findKthLargest(int[] nums, int k) {
        //优先队列默认为小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        //放入前k个元素，堆顶为当前第k大个元素
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            //如果出现数字比堆顶大，那么小顶堆的堆顶就不属于前k大个数，需要poll()重建
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

}
