package org.example.daily;
public class Extra_ReverseInteger_20260422_01 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}