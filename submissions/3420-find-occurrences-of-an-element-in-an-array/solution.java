class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                count++;
            }
        }

        int[] flag = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                flag[index++] = i;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > 0 && queries[i] <= flag.length) {
                result[i] = flag[queries[i] - 1];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}

