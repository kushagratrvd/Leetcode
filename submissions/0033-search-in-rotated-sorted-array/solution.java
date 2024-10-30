class Solution {
    public int BinarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int RotatedIndex = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                RotatedIndex = i;
            }
        }
        int low1 = 0;
        int high1 = RotatedIndex;
        int result1 = BinarySearch(nums, low1, high1, target);
        int low2 = RotatedIndex + 1;
        int high2 = n-1;
        int result2 = BinarySearch(nums, low2, high2, target);
        if(result1 == -1){
            return result2;
        }else{
            return result1;
        }
    }
}
