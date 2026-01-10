class Solution {
    public int dp(String s1, String s2, int i, int j, int[][] dp){
        if(i >= s1.length() && j >= s2.length()) return 0;
        if(i >= s1.length()) return dp[i][j] = s2.charAt(j) + dp(s1,s2,i,j+1,dp);
        else if(j >= s2.length()) return dp[i][j] = s1.charAt(i) + dp(s1,s2,i+1,j,dp);
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = dp(s1, s2, i+1, j+1, dp);

        int delete_s1 = s1.charAt(i) + dp(s1,s2,i+1,j,dp);
        int delete_s2 = s2.charAt(j) + dp(s1,s2,i,j+1,dp);
        return dp[i][j] = Math.min(delete_s1, delete_s2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) Arrays.fill(dp[i],-1);
        return dp(s1, s2, 0, 0,dp);
       // int total = 0;
       // for(char c : s1.toCharArray()) total += c;
        //for(char c : s2.toCharArray()) total += c;
        //return min;
    }
}
