package org.example.daily;
public class SqrtX_20260409_04 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long r = x;
        while (r * r > x) r = (r + x / r) / 2;
        return (int) r;
    }
}