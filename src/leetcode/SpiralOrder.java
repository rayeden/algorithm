package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BG289522
 * @createTime 2019/7/29
 * @description
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2}, {3, 4}, {5,6}
        };
        SpiralOrder so = new SpiralOrder();
        System.out.println(so.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (up <= down && left <= right) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[up][j]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            //关键判断
            if (left < right && up < down) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[down][j]);
                }
                down--;
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
