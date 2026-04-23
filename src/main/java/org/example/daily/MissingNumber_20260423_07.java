package org.example.daily;
public class MissingNumber_20260423_07 {
    public int missingNumber(int[] nums) {
        int n = nums.length, sum = n * (n + 1) / 2;
        for (int v : nums) sum -= v;
        return sum;
    }
}