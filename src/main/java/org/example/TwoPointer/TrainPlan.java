package org.example.TwoPointer;

import java.util.Arrays;

public class TrainPlan {

    public static void main(String[] args) {
        int[] ints = trainingPlan(new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1});
        System.out.println(Arrays.toString(ints));
    }
    public static int[] trainingPlan(int[] actions) {
        Arrays.sort(actions);
        int slow = 1, fast = 2;
        while(fast < actions.length){
            swap(actions, slow, fast);
            slow++;
            fast += 2;
        }
        return actions;
    }
    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
