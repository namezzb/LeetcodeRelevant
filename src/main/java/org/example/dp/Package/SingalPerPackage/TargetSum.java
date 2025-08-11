package org.example.dp.Package.SingalPerPackage;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findTargetSumWays(arr, target));
    }
    public static int findTargetSumWays(int[] nums, int target) {
       int sum = Arrays.stream(nums).sum();
       if((sum + target) % 2 != 0) return 0;
       int left = (sum + target) / 2;
       int[] dp = new int[left + 1];
       dp[0] = 1;
       for(int i = 0; i < nums.length; i++){
           for(int j = dp.length - 1; j >= nums[i]; j--){
               dp[j] = dp[j] + dp[j  - nums[i]];
           }
       }
       return dp[left];
    }
}
