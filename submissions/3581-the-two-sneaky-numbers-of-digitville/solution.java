class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] flags = new boolean[nums.length - 2];
        int[] res = new int[2];
        int count = 0;

        for (int num : nums) {
            if (flags[num]) {
                res[count++] = num;
                if (count == 2) {
                    return res;
                }
            }
            flags[num] = true;
        }

        return res;
    }
}

