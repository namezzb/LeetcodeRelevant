package org.example.daily;
public class Extra_HappyNumber_20260418_02 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do { slow = ds(slow); fast = ds(ds(fast)); } while (slow != fast);
        return slow == 1;
    }
    private int ds(int n) { int s = 0; while (n > 0) { int d = n % 10; s += d * d; n /= 10; } return s; }
}