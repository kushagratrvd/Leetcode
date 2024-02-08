class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] runingSum = new int[nums.length];

        for (int j=0; j<nums.length; j++){
            sum = sum + nums[j];
            runingSum[j] = sum;
        }
        
        return runingSum;
    }
}
