package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sesame
 * @createTime 2019/7/21
 * @description
 */
public class MaxAbsVal {

    public static void main(String[] args) {
        MaxAbsVal mav = new MaxAbsVal();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {-1, 4, 5, 6};
        System.out.println(mav.maxAbsValExpr(arr1, arr2));
        System.out.println(Integer.MIN_VALUE);

        Domino t1 = new Domino(1, 2);
        Domino t2 = new Domino(2, 1);
        System.out.println(t1.equals(t2));
        Map<Domino, Integer> map = new HashMap<>();
        map.put(t1, 1);
        System.out.println(map.containsKey(t2));
        map.put(t2,2);
        System.out.println(map.size());

        for (Map.Entry<Domino, Integer> entry : map.entrySet()){
            entry.getValue();
        }

    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        if (null == arr1 || null == arr2) {
            return 0;
        }
        int length = arr1.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                max = Math.max(max, Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j));
            }
        }
        return max;
    }

}

class Domino {
    private Integer a;
    private Integer b;

    public Domino(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Domino) {
            Domino oo = (Domino) o;
            return oo.a.equals(this.a) && oo.b.equals(this.b) ||
                    oo.a.equals(this.b) && oo.b.equals(this.a);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }
}