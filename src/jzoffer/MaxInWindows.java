package jzoffer;

import java.util.*;

/**
 * @author Sesame
 * @createTime 2019/6/20
 * @description 优先队列
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {

    public static void main(String[] args) {
        MaxInWindows mw = new MaxInWindows();
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(mw.maxInWindows(nums, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0) {
            return new ArrayList<>();
        }
        //大顶堆(lamda)
        PriorityQueue<Integer> pq = new PriorityQueue<>(size, (o1, o2) -> o2 - o1);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(size, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length - size + 1; i++) {
            //每次清空优先队列，重新插入进行堆排序
            for (int j = i; j < i + size; j++) {
                if (pq.size() < size) {
                    pq.add(num[j]);
                }
            }
            res.add(pq.peek());
            pq.clear();
        }
        return new ArrayList<>(res);
    }
}
