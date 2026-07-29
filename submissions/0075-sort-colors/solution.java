class Solution {
    public void sortColors(int[] nums) {
        int lo = 0, mid = 0;
        int hi = nums.length-1;
        while(mid <= hi){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid++] = nums[lo];
                nums[lo++] = temp;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi--] = temp;
            }
        }
        
    }
}
