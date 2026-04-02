package org.example.daily;
public class PowerOfTwo_20260402_03 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}