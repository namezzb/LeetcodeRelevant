package org.example.daily;
public class ContainsDuplicate_20260424_06 {
    public boolean containsDuplicate(int[] nums) {
        var set = new java.util.HashSet<Integer>();
        for (int n : nums) if (!set.add(n)) return true;
        return false;
    }
}