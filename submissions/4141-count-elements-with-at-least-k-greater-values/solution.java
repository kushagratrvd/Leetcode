class Solution {
    public int countElements(int[] nums, int k) {
        if(k==0) return nums.length;
        Arrays.sort(nums);
        for(int i=nums.length-k-1; i>=0; i--){
            if(i+1 < nums.length && nums[i] < nums[i+1]) return i+1;
        }
        return 0;
    }
}
