package org.example.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static Map<Integer, Integer> used = new HashMap<>();
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists.toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target);
        return result;
    }
    public static void backtracking(int[] candidates, int target){
        if(sumOfArray(path) == target){
            if(checkNotUsed(path, used)){
                return;
            }
            result.add(new ArrayList<>(path));
            return;
        } else if (sumOfArray(path) > target) {
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            int curNum = candidates[i];
            path.add(curNum);
            used.put(curNum, used.getOrDefault(curNum, 0) + 1);
            backtracking(candidates, target);
            path.remove(path.size() - 1);
            used.put(curNum, used.get(curNum) - 1);
        }
    }
    public static int sumOfArray(List<Integer> path){
        int sum = 0;
        for(Integer i : path){
            sum += i;
        }
        return sum;
    }

    public static boolean checkNotUsed(List<Integer> path, Map<Integer, Integer> used){
        for(Integer i : path){
            if(used.containsKey(i)){
                int count = used.get(i);
                if(count == 0) return true;
                used.put(i, count - 1);

            }else {
                return true;
            }
        }
        return false;
    }
}
