package leetcode;

/**
 * @author Sesame
 * @createTime 2019/7/20
 * @description
 */
public class Exist {

    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";

        char[][] board = {
                {'A', 'B'}, {'C', 'D'}};
        String word = "ABCD";

        Exist e = new Exist();
        System.out.println(e.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (null == board || 0 == board.length || 0 == board[0].length) {
            return false;
        }
        boolean exist = false;
        int[] index = {0};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                exist = existCore(board, word, index, i, j, board.length, board[0].length, visited);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existCore(char[][] board, String word, int[] index, int row, int col, int rows, int cols, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && index[0] == word.length() - 1 && word.charAt(index[0]) == board[row][col]) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || index[0] < 0 || index[0] >= word.length() || word.charAt(index[0]) != board[row][col]) {
            return false;
        }
        visited[row][col] = true;
        index[0]++;
        boolean exist = existCore(board, word, index, row + 1, col, rows, cols, visited)
                || existCore(board, word, index, row - 1, col, rows, cols, visited)
                || existCore(board, word, index, row, col + 1, rows, cols, visited)
                || existCore(board, word, index, row, col - 1, rows, cols, visited);
        if (exist) {
            return true;
        } else {
            visited[row][col] = false;
            index[0]--;
            return false;
        }
    }
}
