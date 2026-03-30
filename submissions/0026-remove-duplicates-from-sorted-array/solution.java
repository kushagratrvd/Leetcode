class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[prev]){
                nums[prev+1] = nums[i];
                prev++;
            }
        }
        return prev+1;
    }
}
