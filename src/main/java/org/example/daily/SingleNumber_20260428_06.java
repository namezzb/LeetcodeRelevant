package org.example.daily;
public class SingleNumber_20260428_06 {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) r ^= n;
        return r;
    }
}