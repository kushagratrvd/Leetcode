class Solution {
    public int dfs(int sum, int[] nums, int target, int[] dp){
        if(sum == target){
            return 1;
        }
        if(sum > target) return 0;
        if(dp[sum] != -1) return dp[sum];
        int result = 0;
        for(int i=0; i<nums.length; i++){
            if(sum + nums[i] <= target){
                result += dfs(sum + nums[i], nums, target, dp);
            }
            else break;
        }
        return dp[sum] = result;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] ans = new int[]{0};
        Arrays.sort(nums);
        int[] dp = new int[target];
        Arrays.fill(dp, -1);
        dfs(0, nums, target, dp);
        return dp[0]; 
    }
}
