package org.example.daily;
import java.util.Set;
import java.util.HashSet;
public class IntersectionOfTwoArrays_20260408_01 {
    public int[] intersection(int[] nums1, int[] nums2) {
        var s = new HashSet<Integer>(); var r = new HashSet<Integer>();
        for (int n : nums1) s.add(n);
        for (int n : nums2) if (s.contains(n)) r.add(n);
        return r.stream().mapToInt(Integer::intValue).toArray();
    }
}