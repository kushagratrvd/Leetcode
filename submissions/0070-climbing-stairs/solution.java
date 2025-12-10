class Solution {
    public int recursion(int n, int[] dp){
        if(n == 2 || n == 3) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = recursion(n-1,dp) + recursion(n-2,dp);
    }
    public int climbStairs(int n) {
        if(n < 4) return n;
        int[] dp = new int[n+1];
        return recursion(n,dp);
    }
}
