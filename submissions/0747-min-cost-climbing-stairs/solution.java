class Solution {
    public int recursion(int i, int[] cost, int[] dp) {
        if (i >= cost.length) return 0; 
        if (dp[i] != -1) return dp[i];
        int oneStep = recursion(i + 1, cost, dp);
        int twoStep = recursion(i + 2, cost, dp);
        dp[i] = cost[i] + Math.min(oneStep, twoStep);
        return dp[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(recursion(0, cost, dp), recursion(1, cost, dp));
    }
}

