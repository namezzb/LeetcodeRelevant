package org.example.TwoPointer;

// LeetCode 11. 盛最多水的容器
// 双指针从两端向中间移动
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
