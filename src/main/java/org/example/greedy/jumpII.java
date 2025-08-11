package org.example.greedy;

public class jumpII {
    public static int jump(int[] nums) {
        int step = 0;
        int count = 0;
        int jumpTo = 0;
        while(jumpTo < nums.length - 1){
            step = Math.max(step, jumpTo + nums[jumpTo]);
            int curStep = step;
            for(int j = jumpTo; j <= step; j++){
                if(j + nums[j] > curStep){
                    jumpTo = j;
                    curStep = j + nums[j];
                }
            }
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        jump(new int[]{2,1});
    }
}
