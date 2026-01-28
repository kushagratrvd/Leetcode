class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(n==1 && k%2 != 0) return -1;
        int max = 0;
        int maxi = 0;
        if(k > n) maxi = n;
        else maxi = k;
        int i=0;
        for(i = 0; i<maxi; i++){
            if(i == k-1) continue;
            max = Math.max(max, nums[i]);
        }
        if(i < n && nums[i] > max) return nums[i];
        return max;
    }
}
