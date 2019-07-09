package jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sesame
 * @createTime 2019/6/20
 * @description 把优先队列改成普通列表，把堆排序改成快排，牛客OJ速度时间复杂度约10倍，空间复杂度提升约1倍，怀疑是输入数据的关系
 */
public class MaxInWindows2 {

    public static void main(String[] args) {
        MaxInWindows2 mw = new MaxInWindows2();
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(mw.maxInWindows(nums, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size <= 0) {
            return new ArrayList<>();
        }
        List<Integer> list;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < num.length - size + 1; i++) {
            list = new ArrayList<>();
            for (int j = i; j < i + size; j++) {
                list.add(num[j]);
            }
            Collections.sort(list);
            res.add(list.get(list.size() - 1));
        }
        return new ArrayList<>(res);
    }
}
