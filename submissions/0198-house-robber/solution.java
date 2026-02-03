class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[1],nums[0]); 
        for(int i=2; i<n; i++){
            int first = 0;
            int second = 0;
            first = nums[i] + nums[i-2];
            if(i-3 >= 0) second = nums[i] + nums[i-3];
            nums[i] = (int)Math.max(first,second);
        }
        return Math.max(nums[n-1],nums[n-2]);
    }
}
