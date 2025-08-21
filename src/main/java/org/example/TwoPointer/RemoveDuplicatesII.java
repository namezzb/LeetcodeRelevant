package org.example.TwoPointer;

/**
 * 80. 删除有序数组中的重复项 II
 * 
 * 给你一个有序数组 nums，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，
 * 返回删除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组。
 * 
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 */
public class RemoveDuplicatesII {
    
    /**
     * 使用双指针方法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int slow = 2; // 从第三个元素开始
        for (int fast = 2; fast < nums.length; fast++) {
            // 检查当前元素是否应该保留（与前两个保留的元素不同）
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    
    /**
     * 通用解法：可以处理允许重复k次的情况
     */
    public int removeDuplicatesGeneral(int[] nums, int k) {
        if (nums.length <= k) return nums.length;
        
        int slow = k;
        for (int fast = k; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - k]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    
    // 测试方法
    public static void main(String[] args) {
        RemoveDuplicatesII solution = new RemoveDuplicatesII();
        
        // 测试用例1
        int[] nums1 = {1,1,1,2,2,3};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("测试用例1: ");
        for(int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("长度: " + len1);
        
        // 测试用例2
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("测试用例2: ");
        for(int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println("长度: " + len2);
        
        // 测试通用解法
        int[] nums3 = {1,1,1,1,2,2,2,3,3,3};
        int len3 = solution.removeDuplicatesGeneral(nums3, 2); // 允许重复2次
        System.out.print("通用解法测试: ");
        for(int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println("长度: " + len3);
    }
}