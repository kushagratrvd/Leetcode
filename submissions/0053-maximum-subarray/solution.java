class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            /*if(sum < 0 && nums[i] < 0){
                sum = 0;
                continue;
            }*/
            if(sum < 0 && nums[i] > sum) sum = nums[i];
            else sum += nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
