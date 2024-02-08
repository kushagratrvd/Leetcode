class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 1, j=0; i<nums.length; i+=2, j++){
            arr[i-1]= nums[j];
            arr[i]= nums[j+(nums.length)/2];
        }
        return arr;
    }
}
