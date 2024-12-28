class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0, count = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        prefixSumCount.put(0, 1);
        for(int i=0; i<n; i++){
            preSum += nums[i];

            int remove = preSum - k;
            count += prefixSumCount.getOrDefault(remove, 0);
            prefixSumCount.put(preSum, prefixSumCount.getOrDefault(preSum, 0) + 1);

        }
        return count;
    }
}
