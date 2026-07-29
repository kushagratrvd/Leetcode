class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int j = 1;
        int max = nums[0];
        while(j < nums.length){
            
            if(sum < 0) sum = nums[j];
            else sum += nums[j];
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}
