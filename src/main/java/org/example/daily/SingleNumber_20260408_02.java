package org.example.daily;
public class SingleNumber_20260408_02 {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) r ^= n;
        return r;
    }
}