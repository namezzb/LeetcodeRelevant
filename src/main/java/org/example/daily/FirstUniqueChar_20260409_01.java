package org.example.daily;
public class FirstUniqueChar_20260409_01 {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (cnt[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}