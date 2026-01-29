package org.example.bignum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrintBigNumSeq {
    private static StringBuilder sb = new StringBuilder();
    private static char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        List<String> list = countNumbers(2);
        String[] array = list.stream().toArray(String[]::new);
        System.out.println(list.toString());
    }

    public static List<String> countNumbers(int cnt){
        List<String> list = new ArrayList<>();
        dfs(0, list, cnt);
        return list;
    }

    public static void dfs(int x, List<String> list, int cnt){
        if(x == cnt){
            if(sb != null && sb.length() != 0){
                list.add(sb.toString());
            }
            return;
        }
        for(char c : loop){
            if(c != '0') sb.append(c);
            dfs(x + 1, list, cnt);
            if(c != '0') sb.deleteCharAt(sb.length() - 1);
        }
    }
}
