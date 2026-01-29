package org.example.sort;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ResolvePassword {
    public static void main(String[] args) {
        ResolvePassword rs = new ResolvePassword();
        String result = rs.crackPassword(new int[]{15, 8, 7});
        System.out.println(result);
    }

    public String crackPassword(int[] password) {
        String[] pass = new String[password.length];
        for(int i = 0; i < pass.length; i++){
            pass[i] = String.valueOf(password[i]);
        }
        quickSort(pass, 0, pass.length - 1);
        StringBuilder sb = new StringBuilder();
        for(String str : pass){
            sb.append(str);
        }
        return sb.toString();
    }

    public void quickSort(String[] password, int start, int end){
        if(start >= end) return;
        String privot = password[start];
        int slow = start + 1, fast = start + 1;
        while(fast < end){
            String cur = password[fast];
            if((cur + privot).compareTo(privot + cur) < 0){
                swap(password, fast, slow);
                slow++;
            }
            fast++;
        }
        int splitIndex = slow - 1;
        swap(password, splitIndex, start);
        quickSort(password, start, splitIndex - 1);
        quickSort(password, splitIndex + 1, end);
    }

    public void swap(String[] password, int left, int right){
        String temp = password[left];
        password[left] = password[right];
        password[right] = temp;
    }
}
