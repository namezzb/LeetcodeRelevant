package org.example.daily;
public class HappyNumber_20260409_07 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do { slow = dsum(slow); fast = dsum(dsum(fast)); } while (slow != fast);
        return slow == 1;
    }
    private int dsum(int n) {
        int s = 0; while (n > 0) { int d = n % 10; s += d * d; n /= 10; }
        return s;
    }
}