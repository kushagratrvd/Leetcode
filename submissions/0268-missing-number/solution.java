class Solution {
    public int missingNumber(int[] nums) {
        int n  = nums.length;
        int count = 0;
        int total = (n*(n+1))/2;
        for(int i = 0; i < n; i++){
            count+=nums[i];   
        }
        return total - count;
        
    }
}
