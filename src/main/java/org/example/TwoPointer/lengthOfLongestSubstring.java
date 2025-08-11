package org.example.TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        lengOfLongestSubstring("abba");
        findAnagrams("cbaebabacd", "abc");
    }
    public static int lengOfLongestSubstring(String s) {
        if(s.equals("") || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int left = 0, right = 1;
        int max = 1;
        while(right < s.length()){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c, right);
            }else{
                left = map.get(c) + 1;
                map.put(c, right);
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        int[] cur = new int[26];
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()){
            return result;
        }
        for(int i = 0; i < p.length(); i++){
            target[p.charAt(i) - 'a'] += 1;
            cur[s.charAt(i) - 'a'] += 1;
        }
        if(check(cur, target)){
            result.add(0);
        }
        for(int i = 0; i < s.length() - p.length(); i++){
            cur[s.charAt(i) - 'a']--;
            cur[s.charAt(i + p.length()) - 'a']++;
            if(check(cur, target)){
                result.add(i + 1);
            }
        }
        return result;
    }
    public static boolean check(int[] cur, int[] target){
        for(int i = 0; i < cur.length; i++){
            if(cur[i] != target[i]) return false;
        }
        return true;
    }
}
