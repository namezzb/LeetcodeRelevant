package org.example.dp.EditDistance;

public class IsSubSequence {
    public static void main(String[] args) {
        boolean subsequence = isSubsequence("abc", "ahbgdc");
        boolean subsequence1 = isSubsequence1Domain("bb", "ahbgdc");
        System.out.println(subsequence);
        System.out.println(subsequence1);
    }
    public static boolean isSubsequence(String s, String t) {
         int[][] dp = new int[s.length()][t.length()];
         for(int i = 0; i < t.length(); i++){
             char cs = s.charAt(0);
             char ct = t.charAt(i);
             if(cs == ct){
                 for(int j = i; j < t.length(); j++){
                     dp[0][j] = 1;
                 }
                 break;
             }else{
                 dp[0][i] = 0;
             }
         }
        for(int i = 0; i < s.length(); i++){
            dp[i][0] = 0;
        }
        if(s.charAt(0) == t.charAt(0)) dp[0][0] = 1;
        for(int i = 1; i < s.length(); i++){
            for(int j = 1; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1] == s.length();
    }
    public static boolean isSubsequence1Domain(String s, String t){
        int[] dp = new int[s.length()];
        int[] init = new int[t.length()];
        for(int i = 0; i < init.length; i++){
            if(t.charAt(i) == s.charAt(0)){
                for(int j = i; j < init.length; j++){
                    init[j] = 1;
                }
                break;
            }else{
                init[i] = 0;
            }
        }
        if(s.charAt(0) == t.charAt(0)) dp[0] = 1;
        for(int i = 1; i < t.length(); i++){
            for(int j = s.length() - 1; j >= 1; j--){
                dp[0] = init[i - 1];
                if(t.charAt(i) == s.charAt(j)){
                    dp[j] = dp[j - 1] + 1;
                }
            }
        }
        return dp[dp.length - 1] == s.length();
    }

}
