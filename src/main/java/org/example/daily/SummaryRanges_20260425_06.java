package org.example.daily;
import java.util.List;
import java.util.ArrayList;
public class SummaryRanges_20260425_06 {
    public List<String> summaryRanges(int[] nums) {
        var r = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) i++;
            r.add(s == nums[i] ? String.valueOf(s) : s + "->" + nums[i]);
        }
        return r;
    }
}