class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        //int jumps = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<=nums[i]; j++){
                if(i+j >= nums.length-1) return dp[i] + 1;
                if(dp[i+j] == 0) dp[i+j] = dp[i] + 1; 
            } 
        }
        return 0;
    }
}


