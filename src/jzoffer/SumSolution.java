package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/6/28
 * @description
 */
public class SumSolution {

    public static void main(String[] args) {
        SumSolution ss = new SumSolution();
        System.out.println(ss.Sum_Solution(10));
        String a = " ";
        System.out.println(a.length());
        String abc = "abcdef";
        System.out.println(abc.substring(0, 3));
        System.out.println(abc.substring(3, 6));
    }

    public int Sum_Solution(int n) {
        int[] sum = {0};
        sum(n, sum);
        return sum[0];
    }

    private void sum(int n, int[] sum){
        if(n == 0){
            return;
        }
        sum[0] += n;
        sum(n-1, sum);
    }

}
