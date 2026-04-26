package org.example.daily;
public class SqrtX_20260426_05 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long r = x;
        while (r * r > x) r = (r + x / r) / 2;
        return (int) r;
    }
}