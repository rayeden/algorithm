package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/6/20
 * @description
 */
public class MovingCount2 {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || !totalSumValid(row, col, threshold)) {
            return 0;
        }
        visited[row][col] = true;
        return movingCountCore(threshold, rows, cols, row + 1, col, visited)
                + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                + movingCountCore(threshold, rows, cols, row, col - 1, visited) + 1;
    }

    private boolean totalSumValid(int row, int col, int threshold) {
        return (getSum(row) + getSum(col)) <= threshold;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
