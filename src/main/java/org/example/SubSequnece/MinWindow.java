package org.example.SubSequnece;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String s2 = minWindow(s1, "ABC");
        System.out.println(s2);
    }
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mapCheck = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        while(right < s.length()){
            while(!checkAppear(t, mapCheck)){
                if(map.containsKey(s.charAt(right))){
                    mapCheck.put(s.charAt(right), mapCheck.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            }
            while(!map.containsKey(s.charAt(left)) || mapCheck.get(s.charAt(left)) > 1){
                if(mapCheck.containsKey(s.charAt(left))){
                    mapCheck.put(s.charAt(left), mapCheck.get(s.charAt(left)) - 1);
                }
                left++;
            }
            int curLen = right - left + 1;
            if(curLen < minLen){
                minLen = Math.min(minLen, curLen);
                result = s.substring(left, right);
            }
            mapCheck.put(s.charAt(left), mapCheck.get(s.charAt(left)) - 1);
            left++;
        }
        return result;
    }
    public static boolean checkAppear(String t, Map<Character, Integer> mapCheck){
        for(int i = 0; i < t.length(); i++){
            if(!mapCheck.containsKey(t.charAt(i)) || mapCheck.get(t.charAt(i)) < 1){
                return false;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        return  true;
    }
}
