package org.example.daily;
public class SingleNumber_20260414_03 {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) r ^= n;
        return r;
    }
}