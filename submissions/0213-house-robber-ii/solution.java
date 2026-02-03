class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n];
        for(int i=0; i<n; i++) nums2[i] = nums[i];
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[1],nums[0]); 
        if(n == 3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=2; i<n; i++){
            int first = 0;
            int second = 0;
            first = nums[i] + nums[i-2];
            if(i-3 >= 0) second = nums[i] + nums[i-3];
            if(first >= second){
                if(dp[i-2] == 1) dp[i] = 1;
            }
            else if(first <= second){
                if(dp[i-3] == 1) dp[i] = 1;
            } 
            /*else{
                if(dp[i-2] == 1 || dp[i-3] == 1) dp[i] = 2;
            } */
            nums[i] = (int)Math.max(first,second);
        }
        int max1 = 0;
        if(dp[n-1] == 1) max1 = Math.max(nums[n-3],nums[n-2]);
        else return Math.max(nums[n-1],nums[n-2]);
        nums2[0] = 0;
        for(int i=2; i<n; i++){
            int first = 0;
            int second = 0;
            first = nums2[i] + nums2[i-2];
            if(i-3 >= 0) second = nums2[i] + nums2[i-3];
            nums2[i] = (int)Math.max(first,second);
        }
        return Math.max(max1,Math.max(nums2[n-1],nums2[n-2]));
    }
}
