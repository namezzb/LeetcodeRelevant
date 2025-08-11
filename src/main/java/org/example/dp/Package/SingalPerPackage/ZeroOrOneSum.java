package org.example.dp.Package.SingalPerPackage;

public class ZeroOrOneSum {
    public static void main(String[] args) {
        String[] s = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(s, 5, 3));
    }
    //strs = ["10", "0001", "111001", "1", "0"]
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroNum = 0;
        int oneNum = 0;
        for(String s : strs) {
            for(char c : s.toCharArray()) {
                if(c == '0') {
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }
            for(int i = dp.length - 1; i >= zeroNum; i--) {
                for(int j = dp[i].length - 1; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
