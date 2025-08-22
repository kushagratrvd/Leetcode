class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for(int i=1; i<nums.length; i++){
            product = product * nums[i-1];
            arr[i] = product;    
        }
        product = nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--){
            arr[i] = arr[i]*product;
            product = product * nums[i];
        }
        return arr;
    }
}
