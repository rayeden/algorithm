package jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sesame
 * @createTime 2019/6/28
 * @description
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] numbers = {0, 3, 2, 6, 4};
        IsContinuous ic = new IsContinuous();
        System.out.println(ic.isContinuous(numbers));
    }

    public boolean isContinuous(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return false;
        }
        if (numbers.length == 1) {
            return true;
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            } else {
                list.add(numbers[i]);
            }
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff == 0) {
                return false;
            }
            if (diff == 1) {
                continue;
            } else {
                count = count - diff + 1;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
