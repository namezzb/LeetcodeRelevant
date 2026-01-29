package org.example.specialarr;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{4,3,4,1,1,4,1,4}));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 1 || nums[i] > nums.length || nums[i] - 1 == i) continue;
            int curNum = nums[i];
            if(nums[curNum - 1] == curNum) continue;
            while(curNum - 1 != i){
                if(curNum < 1 || curNum > nums.length) break;
                if(nums[curNum - 1] == curNum) break;
                int moveTo = curNum - 1;
                int temp = nums[moveTo];
                nums[moveTo] = nums[i];
                nums[i] = temp;
                curNum = nums[i];
            }
        }
        int result = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                result = i + 1;
                break;
            }
        }
        return result == -1 ? nums.length + 1 : result;
    }
}
