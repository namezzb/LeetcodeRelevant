package org.example.daily;
import java.util.List;
import java.util.ArrayList;
public class FizzBuzz_20260417_03 {
    public List<String> fizzBuzz(int n) {
        var ans = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) ans.add("FizzBuzz");
            else if (i % 3 == 0) ans.add("Fizz");
            else if (i % 5 == 0) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        return ans;
    }
}