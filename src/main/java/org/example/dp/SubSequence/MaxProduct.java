package org.example.dp.SubSequence;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        int i = maxProduct(new int[]{2, -5, -2, -4, 3});
        maxProduct1(new int[]{-4,-3});
        System.out.println(i);
    }
    public static int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curNum = nums[i];
            dp_min[i] = Math.min(curNum * dp_min[i - 1], Math.max(curNum, curNum * dp_max[i - 1]));
            dp_max[i] = Math.max(curNum * dp_min[i - 1], Math.max(curNum, curNum * dp_max[i - 1]));
            max = Math.max(max, dp_max[i]);
        }
        return max;
    }
    public static int maxProduct1(int[] nums) {
        if(nums.length <= 1) return nums[0];
        int[] dp = Arrays.copyOfRange(nums, 0, nums.length);
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < dp.length; i++){
            if(dp[i - 1] * nums[i] > dp[i]){
                dp[i] = dp[i - 1] * nums[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
