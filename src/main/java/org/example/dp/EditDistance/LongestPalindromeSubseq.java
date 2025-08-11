package org.example.dp.EditDistance;

public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        int i = longestPalindromeSub("bbbab");
        System.out.println(i);
    }
    public static int longestPalindromeSub(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[s.length() - 1][s.length() - 1] = true;
        int maxLen = Integer.MIN_VALUE;
        for(int i  = s.length() - 2; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                        maxLen = Math.max(maxLen, j - i + 1);
                    }else{
                        if(dp[i + 1][j - 1]){
                            dp[i][j] = true;
                            maxLen = Math.max(maxLen, j - i + 1);
                        }
                    }
                }
            }
        }
        return maxLen;
    }
}
