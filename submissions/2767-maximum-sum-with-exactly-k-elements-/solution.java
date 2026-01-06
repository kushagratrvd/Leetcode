class Solution {
    public int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int x : nums) max = Math.max(max, x);
        int sum = max * k + (k-1)*(k)/2;
        return sum;
    }
}
