package org.example.dp.Package.SingalPerPackage;

public class CartPartition {
    public static void main(String[] args) {
        boolean b = canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if(sum % 2 != 0) return false;
        int bagSize = sum(nums) / 2;
        int[][] dp = new int[bagSize][bagSize + 1];
        for(int i = nums[0]; i <= bagSize; i++){
            dp[0][i] = nums[0];
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= bagSize; j++){
                if(j >= nums[i]){
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i]] + nums[i], dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == bagSize;
    }
    public static int sum(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        return sum;
    }
}
