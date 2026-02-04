class Solution {
    public int robbery(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = start; i <= end; i++){
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[1],nums[0]);
        return Math.max(robbery(nums,0,nums.length-2),robbery(nums,1,nums.length-1));
    }
}
