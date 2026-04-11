class Solution {
    public boolean helper(int[] nums, int ind, int sum, int target, Boolean[][] dp){
        if(sum > target || ind >= nums.length) return dp[ind][sum] = false;
        if(dp[ind][sum] != null) return false;
        if(sum == target) return true;
        while(ind < nums.length-1 && sum + nums[ind] > target){
            System.out.println(ind);
            dp[ind][sum+nums[ind+1]] = false;
            ind++;
        }
        if(helper(nums, ind+1, sum + nums[ind], target, dp)) return true;
        if(helper(nums, ind+1, sum, target, dp)) return true;
        return dp[ind][sum] = false;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) sum += nums[i];
        if(sum%2 != 0) return false;
        Boolean[][] dp = new Boolean[201][20001]; 
        if(helper(nums, 0, 0, sum/2, dp)) return true;
        return false;
    }
}
