class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        // Precompute suffix sums of only positives and only negatives
        int[] posSum = new int[n + 1]; // max we can still add
        int[] negSum = new int[n + 1]; // min we can still add

        for (int i = n - 1; i >= 0; i--) {
            posSum[i] = posSum[i + 1] + (nums[i] > 0 ? nums[i] : 0);
            negSum[i] = negSum[i + 1] + (nums[i] < 0 ? nums[i] : 0);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) count++;

                // remaining elements are indices j+1 to n-1
                if (sum + posSum[j + 1] < k) break; // can never reach k
                if (sum + negSum[j + 1] > k) break; // already past k, can't recover
            }
        }
        return count;
    }
}
