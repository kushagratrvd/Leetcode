class Solution {
    public int longestSubarray(int[] nums) {
        int count = 2;
        int max = 2;
        for(int i=0,j=1; j<nums.length; i++){
            if(j+1 < nums.length && nums[i] + nums[j] == nums[j+1]) count++;
            else count = 2;
            j++;
            max = Math.max(max,count);
        }
        return max;
    }
}
