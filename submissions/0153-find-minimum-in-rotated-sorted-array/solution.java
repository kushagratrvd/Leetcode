class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = nums[0];
        while(low <= high){
            int mid = (low + high)/2;
            min = Math.min(min, nums[mid]);
            if(nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid + 1;
                if(low <= high && nums[low] <= min ){
                    return nums[low];
                }
            }
            else{
                min = Math.min(min, nums[mid]);
                high = mid - 1;
                // if(low <= high && nums[high] <= min ){
                //     min = nums[high];
                // }
            }
        }
        return min;
    }
}
