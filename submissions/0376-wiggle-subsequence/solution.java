class Solution {
    int[][][] dp;

    int solve(int idx, int prev, int up, int[] nums) {
        if (idx == nums.length) return 0;

        if (dp[idx][prev + 1][up] != -1)
            return dp[idx][prev + 1][up];

        int notTake = solve(idx + 1, prev, up, nums);
        int take = 0;

        if (prev == -1 ||
           (up == 1 && nums[idx] > nums[prev]) ||
           (up == 0 && nums[idx] < nums[prev])) {
            take = 1 + solve(idx + 1, idx, 1 - up, nums);
        }

        return dp[idx][prev + 1][up] = Math.max(take, notTake);
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= n; j++)
                Arrays.fill(dp[i][j], -1);

        return Math.max(
            solve(0, -1, 1, nums),
            solve(0, -1, 0, nums)
        );
    }
}

