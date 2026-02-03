class Solution {
    public int integerBreak(int n) {
        //interesting pattern [0,1,2,3,4,6,9,12,18,27,36,..]
        if(n <= 3) return n-1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            int product = 0;
            for(int j = 1; j <= i/2; j++){
                product = Math.max(product, dp[j] * dp[i-j]);
            }
            dp[i] = product;
        }
        return dp[n]; 
    }
}
