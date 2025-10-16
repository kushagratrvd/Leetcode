class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] freq = new int[value];
        
        for (int num : nums) {
            int mod = ((num % value) + value) % value; // handle negatives properly
            freq[mod]++;
        }

        int k = 0;
        while (true) {
            int mod = k % value;
            if (freq[mod] == 0) return k;
            freq[mod]--;
            k++;
        }
    }
}
