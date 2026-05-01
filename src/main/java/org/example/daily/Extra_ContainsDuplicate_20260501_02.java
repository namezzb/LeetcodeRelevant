package org.example.daily;
public class Extra_ContainsDuplicate_20260501_02 {
    public boolean containsDuplicate(int[] nums) {
        var set = new java.util.HashSet<Integer>();
        for (int n : nums) if (!set.add(n)) return true;
        return false;
    }
}