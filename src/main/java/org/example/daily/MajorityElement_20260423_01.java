package org.example.daily;
public class MajorityElement_20260423_01 {
    public int majorityElement(int[] nums) {
        int cand = 0, cnt = 0;
        for (int n : nums) {
            if (cnt == 0) cand = n;
            cnt += (n == cand) ? 1 : -1;
        }
        return cand;
    }
}