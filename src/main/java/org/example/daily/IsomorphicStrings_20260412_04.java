package org.example.daily;
public class IsomorphicStrings_20260412_04 {
    public boolean isIsomorphic(String s, String t) {
        int[] ms = new int[256], mt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (ms[s.charAt(i)] != mt[t.charAt(i)]) return false;
            ms[s.charAt(i)] = i + 1; mt[t.charAt(i)] = i + 1;
        }
        return true;
    }
}