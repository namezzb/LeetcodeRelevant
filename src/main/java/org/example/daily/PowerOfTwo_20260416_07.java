package org.example.daily;
public class PowerOfTwo_20260416_07 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}