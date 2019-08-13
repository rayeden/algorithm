package leetcode.dp;

import java.util.Arrays;

/**
 * @author Sesame
 * @createTime 2019/7/18
 * @description
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        System.out.println(cc.coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (null == coins || 0 == coins.length || 0 == amount) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //零钱可以被凑
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
