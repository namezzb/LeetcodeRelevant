package org.example.daily;
import java.util.List;
import java.util.ArrayList;
public class PascalsTriangle_20260424_03 {
    public List<List<Integer>> generate(int n) {
        var r = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            var row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++)
                row.add(j == 0 || j == i ? 1 : r.get(i - 1).get(j - 1) + r.get(i - 1).get(j));
            r.add(row);
        }
        return r;
    }
}