class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = 0;
        while(low<=high){
            mid = (low+high)/2;
            /*if(low + 1 == high && nums[low] < target && nums[high] > target){
                mid = high;
                return high;
            } 
            if(nums[mid] < target && mid+1 < n && nums[mid + 1]>target){
                return mid+1;
            }*/
            if(nums[mid] < target){
                low = mid+1;
               /* if(low == high && target < nums[low]){
                  return low;
                  }*/
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                return mid;
            }
            
        }
        if(target < nums[0]){
            return 0;
        }
        return low;
    }
}
