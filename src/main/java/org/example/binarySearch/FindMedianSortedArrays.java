package org.example.binarySearch;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int div = (len1 + len2) % 2;
        if(div == 1){
            int mid = (len1 + len2) / 2;
            double kthMin = findKthMin(nums1, nums2, mid + 1);
            return kthMin;
        }else{
            int left = (len1 + len2) / 2;
            int right = left + 1;
            double l = findKthMin(nums1, nums2, left);
            double r = findKthMin(nums1, nums2, right);
            return (l + r) / 2;
        }
    }
    public int findKthMin(int[] nums1, int[] nums2, int k){
        int index1 = 0;
        int index2 = 0;

        while(true){
            if(index1 >= nums1.length){
                return nums2[index2 + k - 1];
            }
            if(index2 >= nums2.length){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            int half = k / 2;
            int nextN1 = Math.min(nums1.length, index1 + half) - 1;
            int nextN2 = Math.min(nums2.length, index2 + half) - 1;
            if(nums1[nextN1] <= nums2[nextN2]){
                int removedCount = nextN1 - index1 + 1;
                k -= removedCount;
                index1 = nextN1 + 1;
            }else{
                int removedCount = nextN2 - index2 + 1;
                k -= removedCount;
                index2 = nextN2 + 1;
            }
        }
    }
}
