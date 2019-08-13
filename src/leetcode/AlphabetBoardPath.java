package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/28
 * @description
 */
public class AlphabetBoardPath {

    public static void main(String[] args) {
        AlphabetBoardPath ab = new AlphabetBoardPath();
        System.out.println(ab.alphabetBoardPath("leetcode"));
    }

    private static String[] strs = {
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "uvwxy",
            "z"
    };

    public String alphabetBoardPath(String target) {
        char[][] grid = new char[6][5];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = strs[i].toCharArray();
        }
        int[] index = {0};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean flag = alphabetBoardPathCore(grid, i, grid.length, j, grid[0].length, target, index, res, "");
                if (flag) {
                    return res.toString();
                }
            }
        }
        return "";
    }

    public boolean alphabetBoardPathCore(char[][] grid, int row, int rows, int col, int cols, String target, int[] index, StringBuilder res, String toward) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        if (target.charAt(index[0]) == grid[row][col]) {
            res.append(toward);
            res.append("!");
            index[0]++;
            if (index[0] == target.length()) {
                return true;
            }
        } else {
            res.append(toward);
        }
        boolean flag = alphabetBoardPathCore(grid, row + 1, rows, col, cols, target, index, res, "U")
                || alphabetBoardPathCore(grid, row - 1, rows, col, cols, target, index, res, "D")
                || alphabetBoardPathCore(grid, row, rows, col + 1, cols, target, index, res, "R")
                || alphabetBoardPathCore(grid, row, rows, col - 1, cols, target, index, res, "L");
        if (!flag) {
            index[0]--;
            res.deleteCharAt(res.length() - 1);
        }

        return false;
    }
}
