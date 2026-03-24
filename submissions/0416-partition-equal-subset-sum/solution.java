class Solution {
    public boolean helper(int curr, int ind, int sum, int[] nums, Boolean[][] dp){
        if(curr == sum) return true;
        if(curr > sum || ind >= nums.length-1 || dp[ind][curr] != null) return dp[ind][curr] = false;
        //System.out.println("curr: "+ curr+ " ind: "+ ind);
        //System.out.println("curr + nums[ind+1]: "+ (curr+nums[ind+1])+ " ind+1: "+ (ind+1));
        while(ind < nums.length-1 && curr + nums[ind+1] > sum){
            System.out.println(ind);
            dp[ind][curr] = false;
            ind++;
        }
        if(ind >= nums.length-1) return dp[ind][curr] = false;
        if(helper(curr + nums[ind+1], ind+1, sum, nums, dp)) return true;
        return dp[ind][curr] = helper(curr, ind+1, sum, nums, dp);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        sum = sum/2;
        Boolean[][] dp = new Boolean[nums.length][sum*2+1];

        //System.out.println(sum);
        return helper(nums[0], 0, sum, nums, dp) || helper(0, 0, sum, nums, dp);
        
    }
}
