package leetcode;

/**
 * @author BG289522
 * @createTime 2019/7/28
 * @description
 */
public class Tribonacci {

    public static void main(String[] args) {
        Tribonacci tc = new Tribonacci();
        System.out.println(tc.tribonacci(4));
    }


    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

}
