package org.example.singleStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] ints = nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(Arrays.toString(ints));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int[] record = new int[nums2.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(0);
        for(int i = 1; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peekLast()]){
                int tempIndex = stack.pollLast();
                record[tempIndex] = nums2[i];
            }
            stack.offer(i);
        }
        for(int i = 0; i < result.length; i++){
            int num2index = getIndex(nums2, nums1[i]);
            result[i] = record[num2index] != 0 ? record[num2index] : -1;
        }
        return result;
    }
    public static int getIndex(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }
}
