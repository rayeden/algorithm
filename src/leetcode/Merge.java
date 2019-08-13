package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sesame
 * @createTime 2019/7/16
 * @description
 */
public class Merge {

    public static void main(String[] args) {
        Merge mg = new Merge();
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        int[][] res = mg.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.asList(intervals);
        List<int[]> res = new ArrayList<>();
        list.sort((o1, o2) -> o1[0] - o2[0]);
        int min = list.get(0)[0];
        int max = list.get(0)[1];
        Iterator<int[]> iter = list.iterator();
        while (iter.hasNext()) {
            int[] interval = iter.next();
            if (interval[0] == min) {
                max = Math.max(max, interval[1]);
            } else {
                //interval[0] > min
                if (interval[0] <= max) {
                    max = Math.max(max, interval[1]);
                } else {
                    res.add(new int[]{min, max});
                    min = interval[0];
                    max = interval[1];
                    if (!iter.hasNext()) {
                        res.add(new int[]{min, max});
                    }
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
