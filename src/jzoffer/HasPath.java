package jzoffer;

/**
 * @author xhtc
 * @createTime 2019/6/20
 * @description 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {

    public static void main(String[] args) {
        HasPath hp = new HasPath();
        String s = "ABCESFCSADEE";
        String ss = "ABCCED";
        char[] matrix = s.toCharArray();
        char[] str = ss.toCharArray();
        System.out.println(hp.hasPath(matrix, 3, 4, str));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (null == matrix || matrix.length == 0 || matrix.length != rows * cols || matrix.length < str.length) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int[] index = {0};
                if(hasPathCore(matrix, rows, cols, i, j, str, index, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                char[] str, int[] index, boolean[] visited){
        boolean flag = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && !visited[cols * row + col]
                && matrix[row *cols + col] == str[index[0]]){
            visited[row * cols + col] = true;
            //判断是否到达字符串最后一个字符，若相等则找到匹配字符串，返回true
            if(++index[0] == str.length){
                return true;
            }
            flag = hasPathCore(matrix, rows, cols, row + 1, col, str, index, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, index, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, index, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, index, visited);
            //没有找到匹配字符串，回溯
            if(!flag){
                index[0]--;
                visited[row * cols + col] = false;
            }
        }
        return flag;
    }
}
