package org.example.dp.SubSequence;

public class MaxSubCommonStirng {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        longestCommonSubsequence(s1, s2);
        longestCommonSubSequenceDifInit(s1, s2);
    }

    public static int longestCommonSubSequenceDifInit(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    public static int longestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length()][text2.length()];
        char s1 = text1.charAt(0);
        char s2 = text2.charAt(0);
        for(int i = 0; i < text1.length(); i++){
            if(s2 == text1.charAt(i)){
                for(int j = i; j < text2.length(); j++){
                    dp[0][j] = 1;
                }
                break;
            }else{
                dp[0][i] = 0;
            }
        }
        for(int i = 0; i < text2.length(); i++){
            if(s1 == text2.charAt(i)){
                for(int j = i; j < text1.length(); j++){
                    dp[j][0] = 1;
                }
                break;
            }else{
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i < text1.length(); i++){
            for(int j = 1; j < text2.length(); j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
