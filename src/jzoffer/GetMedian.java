package jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sesame
 * @createTime 2019/6/20
 * @description
 */
public class GetMedian {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        GetMedian gm = new GetMedian();
        int[] nums = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int n : nums) {
            gm.Insert(n);
            System.out.println(gm.GetMedian());
        }
    }

    private void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    private Double GetMedian() {
        int size = list.size();
        int index = size / 2;
        if (size % 2 != 0) {
            return (double) list.get(index);
        } else {
            int sum = list.get(index) + list.get(index - 1);
            return (double)sum / 2;
        }
    }


}
