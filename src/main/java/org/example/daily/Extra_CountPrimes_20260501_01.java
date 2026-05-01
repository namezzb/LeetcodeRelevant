package org.example.daily;
public class Extra_CountPrimes_20260501_01 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] np = new boolean[n]; int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!np[i]) { cnt++; if ((long)i*i < n) for (int j = i*i; j < n; j += i) np[j] = true; }
        }
        return cnt;
    }
}