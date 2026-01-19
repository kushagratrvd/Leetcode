class Solution {
    public long solve(int[] nums1, int[] nums2, int i, int j, long[][] dp){
        if(i == nums1.length || j == nums2.length) return Integer.MIN_VALUE;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        long first = nums1[i] * nums2[j];
        long second = first + solve(nums1, nums2, i+1, j+1, dp);
        long third = solve(nums1, nums2, i, j+1, dp);
        long fourth = solve(nums1, nums2, i+1, j, dp);
        long max1 = Math.max(first, second);
        long max2 = Math.max(max1, third);
        long max3 = Math.max(max2, fourth);
        return dp[i][j] = max3;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        long[][] dp = new long[501][501];
        for(int i=0; i<501; i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        return (int)solve(nums1, nums2, 0, 0, dp);
    }
}
