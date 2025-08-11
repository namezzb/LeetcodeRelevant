package org.example.dp.Package.FullPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullSquareNum {
    public static void main(String[] args) {
        int i = numSquares(49);
        System.out.println(i);
    }
    public static int numSquares(int n) {
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while(true){
            if(count * count <= n){
                list.add(count*count);
            }
            else {
                break;
            }
            count++;
        }
        int size = list.size();
        int[] weight = new int[size];
        for(int i = 0; i < size; i++){
            weight[i] = list.get(i);
        }
        int[] dp = new int[n + 1];
        int init_num = n + 1;
        Arrays.fill(dp, init_num);
        dp[0] = 0;
        for(int i = 0; i < weight.length; i++){
            for(int j = weight[i]; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
            }
        }
        return dp[dp.length - 1] > n ? 0 : dp[dp.length - 1];
    }
}
