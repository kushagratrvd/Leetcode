class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            //if(i > max) max = i;
            sum += i;
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}
