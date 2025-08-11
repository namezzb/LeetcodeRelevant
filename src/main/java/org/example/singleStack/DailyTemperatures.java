package org.example.singleStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        stack.offer(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]){
                int tempIndex = stack.pollLast();
                result[tempIndex] = i - tempIndex;
            }
            stack.offer(i);
        }
        return result;
    }
}
