package org.example.daily;
public class MaxProfit_20260501_01 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else profit = Math.max(profit, p - min);
        }
        return profit;
    }
}