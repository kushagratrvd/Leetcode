class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[1],nums[0]); 
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int jump1 = 0;
        int jump2 = 0;
        for(int i=2; i<n; i++){
            if(i-3 >= 0) jump1 = nums[i] + dp[i-3];
            jump2 = nums[i] + dp[i-2];
            dp[i] = (int)Math.max(jump1,jump2);
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
}
