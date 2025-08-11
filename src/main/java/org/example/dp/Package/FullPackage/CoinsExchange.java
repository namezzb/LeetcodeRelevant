package org.example.dp.Package.FullPackage;


import java.util.Arrays;

public class CoinsExchange {
    public static void main(String[] args) {
        int[][] ints = coinChange(new int[]{2, 5, 10, 1}, 27);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
    public static int[][] coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE;
        }
        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i] && dp[i][j - coins[i]] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
