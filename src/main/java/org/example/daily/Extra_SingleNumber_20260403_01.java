package org.example.daily;
public class Extra_SingleNumber_20260403_01 {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) r ^= n;
        return r;
    }
}