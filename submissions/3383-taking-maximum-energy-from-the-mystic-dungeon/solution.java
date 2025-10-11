class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        //int[] dp = energy.clone();
        for (int i = n - 1 - k; i >= 0; --i) {
            energy[i] += energy[i + k];
        }

        int maxEnergy = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEnergy = Math.max(maxEnergy, energy[i]);
        }
        return maxEnergy;
    }
}
