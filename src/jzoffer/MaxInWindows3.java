package jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xhtc
 * @createTime 2019/6/25
 * @description
 */
public class MaxInWindows3 {

    public static void main(String[] args) {
        MaxInWindows3 mw = new MaxInWindows3();
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(mw.maxInWindows(nums, 3));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if(null == num){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < num.length - size + 1; i++){
            tmp.clear();
            for(int j = i; j < i + size; j++){
                tmp.add(num[j]);
            }
            Collections.sort(tmp);
            list.add(tmp.get(size - 1));
        }
        return new ArrayList<>(list);
    }
}
