class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int product = 1;
        ans[0] = 1;
        for(int i=1; i<n; i++){
            product *= nums[i-1];
            ans[i] = product;
        }
        product = nums[n-1];
        for(int i=n-2; i>=0; i--){
            ans[i] = ans[i] * product;
            product *= nums[i];
        }
        return ans;
    }
}
