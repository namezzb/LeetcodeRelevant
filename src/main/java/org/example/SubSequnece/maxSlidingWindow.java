package org.example.SubSequnece;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow1(nums, 3);
    }
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for(int i = 0; i < k; i++){
            pq.add(new int[]{i, nums[i]});
        }
        result[0] = pq.peek()[1];
        int index = 1;
        for(int i = k; i < nums.length; i++){
            pq.add(new int[]{i, nums[i]});
            while(pq.peek()[0] <= i - k){
                pq.poll();
            }
            result[index] = pq.peek()[1];
            ++index;
        }
        return result;
    }
}
