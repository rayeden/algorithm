package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sesame
 * @createTime 2019/7/23
 * @description
 */
public class OrangesRotting {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        };
        OrangesRotting or = new OrangesRotting();
        System.out.println(or.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        if (null == grid || 0 == grid.length || 0 == grid[0].length) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q1 = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q1.add(new int[]{i, j});
                }
            }
        }
        int sumMin = 0;
        Queue<int[]> q2 = new LinkedList<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                int[] geo = q1.poll();
                int row = geo[0], col = geo[1];
                System.out.println(row + " " + col);
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    q2.add(new int[]{row - 1, col});
                }
                if (row + 1 < rows && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    q2.add(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    q2.add(new int[]{row, col - 1});
                }
                if (col + 1 < cols && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    q2.add(new int[]{row, col + 1});
                }
            }
            if(!q2.isEmpty()){
                sumMin ++;
                while (!q2.isEmpty()) {
                    q1.add(q2.poll());
                }
            }
        }
        return sumMin;
    }
}
