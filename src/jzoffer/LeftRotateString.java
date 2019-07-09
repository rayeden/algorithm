package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sesame
 * @createTime 2019/6/28
 * @description
 */
public class LeftRotateString {

    public static void main(String[] args) {

    }

    public String leftRotateString(String str, int n) {
        if (str == null) {
            return str;
        }
        if (str.trim().equals("")) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.substring(n, str.length()));
        sb.append(str.substring(0, n));
        return sb.toString();
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = map.get(array[i]);
            map.put(array[i], count == null ? 1 : count + 1);
        }
        Integer n1 = null, n2 = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (n1 == null) {
                    n1 = entry.getKey();
                } else {
                    n2 = entry.getKey();
                    break;
                }
            }
        }
        num1[0] = n1;
        num2[0] = n2;
    }
}
