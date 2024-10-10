class Solution {
    public int First(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int first = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(target < nums[mid]){
                high = mid-1;
            }
            else if(target > nums[mid]){
                low = mid+1;
            }
            else{
                first = mid;
                high = mid-1;
            }
        }
        return first;
    }
    public int Last(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int last = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(target < nums[mid]){
                high = mid-1;
            }
            else if(target > nums[mid]){
                low = mid+1;
            }
            else{
                last = mid;
                low = mid+1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = First(nums,target);
        result[1] = Last(nums, target);
        // int[] result = {-1,-1};
        // if(nums.length == 1 && nums[0] == target){
        //     result[0] = result[1] = 0;
        //     return result;
        // }
        
        return result;
    }
}
