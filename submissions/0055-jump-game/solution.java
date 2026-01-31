class Solution {
    public boolean jumping(int ind, int[] nums, int[] dp) {
        if(ind >= nums.length) return false;
        for(int j = nums[ind]; j > 0; j--){
            int start = ind + j;
            if(start == nums.length-1) return true;
            if(start >= nums.length) continue;
            if(dp[start] != 0) continue;
            if(jumping(start, nums, dp)) return true;
            else dp[start] = 1;
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == 0) return false;
            if(dp[i] != 0) continue;
            if(jumping(i, nums, dp)) return true;
            else dp[i] = 1;
        }
        return false;
    }
}
