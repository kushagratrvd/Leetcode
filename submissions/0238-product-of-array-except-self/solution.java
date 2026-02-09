class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        int product = nums[0];
        for(int i = 1; i<n; i++){
            result[i] = product;
            product *= nums[i];
        }
        product = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            result[i] = result[i] * product;
            product *= nums[i];
        }
        return result;
    }
}
