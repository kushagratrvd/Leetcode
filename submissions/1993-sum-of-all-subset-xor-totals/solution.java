class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0) return 0;
        int or = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            or = or | nums[i];
        }
        return or << n-1;
    }
}
