package org.example.daily;
public class TwoSum_20260408_06 {
    public int[] twoSum(int[] nums, int target) {
        var map = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) return new int[]{map.get(c), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}