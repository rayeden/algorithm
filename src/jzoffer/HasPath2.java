package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/6/21
 * @description
 */
public class HasPath2 {

    public static void main(String[] args) {
        HasPath2 hp = new HasPath2();
//        String s = "ABCESFCSADEE";
        String s = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
//        String ss = "ABCCED";
        String ss = "SGGFIECVAASABCEHJIGQEM";
        char[] matrix = s.toCharArray();
        char[] str = ss.toCharArray();
        System.out.println(hp.hasPath(matrix, 5, 8, str));
    }


    private boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || matrix.length != rows * cols ||
                str == null || str.length == 0 || matrix.length < str.length) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //index[0]={0} 每次循环都需要重置
                int[] index = {0};
                if (hasPathCore(matrix, rows, cols, i, j, index, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, int[] index, char[] str, boolean[] visited) {
        boolean flag = false;

        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col]
                && str[index[0]] == matrix[row * cols + col]) {
            visited[row * cols + col] = true;
            //先++ 后比较长度
            if (++index[0] == str.length) {
                return true;
            }
            flag = hasPathCore(matrix, rows, cols, row + 1, col, index, str, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, index, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, index, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, index, str, visited);

            if (!flag) {
                index[0]--;
                visited[row * cols + col] = false;
            }
        }
        return flag;
    }

}
