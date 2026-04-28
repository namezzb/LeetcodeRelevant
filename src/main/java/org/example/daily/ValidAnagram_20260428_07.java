package org.example.daily;
public class ValidAnagram_20260428_07 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        for (char c : t.toCharArray()) if (--cnt[c - 'a'] < 0) return false;
        return true;
    }
}