class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int i = nums.length-1;
        int prev = nums[i--];
        while(i >= 0){
            if(nums[i] < prev) break;
            prev = nums[i--];
        }
        int j=nums.length-1;
        int temp = 0;
        if(i < 0){
            i = 0;
        }
        else{
            while(nums[j] <= nums[i]) j--;
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j = nums.length-1;
        }
        
        while(i < j){
            temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
