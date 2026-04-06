package org.example.daily;
public class HammingWeight_20260406_06 {
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) { n &= (n - 1); c++; }
        return c;
    }
}