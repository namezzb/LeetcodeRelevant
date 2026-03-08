package org.example.dp;

// LeetCode 70. 爬楼梯
// 时间复杂度: O(n), 空间复杂度: O(1)
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
