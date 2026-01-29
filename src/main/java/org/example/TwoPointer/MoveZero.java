package org.example.TwoPointer;

public class MoveZero {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;
        while(index < nums.length && nums[index] == 0){
            index++;
        }
        int left = index - 1, right = index - 1;
        while(right < nums.length){
            if(right == 0){
                right++;
            }else{
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right++;
            }
        }
    }
}
