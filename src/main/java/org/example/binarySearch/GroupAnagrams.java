package org.example.binarySearch;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++){
            if(visited[i]){
                continue;
            }
            
            List<String> cur = new ArrayList<>();
            cur.add(strs[i]);
            visited[i] = true;
            
            // 存储当前单词的字符计数
            int[] pattern = getCharCount(strs[i]);
            
            for(int j = i + 1; j < strs.length; j++){
                if(visited[j]){
                    continue;
                }
                
                // 判断是否为字母异位词
                if(isAnagram(strs[j], pattern)){
                    cur.add(strs[j]);
                    visited[j] = true;
                }
            }
            
            result.add(cur);
        }
        
        return result;
    }
    
    // 判断是否为字母异位词
    public static boolean isAnagram(String s, int[] pattern) {
        if (s.length() != sum(pattern)) {
            return false;
        }
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] != pattern[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    // 获取字符串的字符计数
    public static int[] getCharCount(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
    
    // 计算数组中所有元素之和
    private static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }
}
