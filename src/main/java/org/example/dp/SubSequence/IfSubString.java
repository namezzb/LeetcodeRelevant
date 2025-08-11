package org.example.dp.SubSequence;

import java.util.Arrays;
import java.util.Scanner;

public class IfSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int volnum = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < value.length; i++) {
            value[i] = sc.nextInt();
        }
        int[] dp = new int[volnum + 1];
        for(int i = 0; i < value.length; i++){
            for(int j = dp.length - 1; j >= 0; j--){
                if(j >= weight[i]){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
