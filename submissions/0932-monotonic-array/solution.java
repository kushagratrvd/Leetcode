class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        int small = 0;
        int large = 0;
        if(nums[0] > nums[1]){
            for(int i=1; i < nums.length-1; i++){
                if(nums[i] < nums[i+1]){
                    return false;
                }
            }
            return true;
        }
        if(nums[0] < nums[1]){
            for(int i=1; i < nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    return false;
                }
            }
            return true;
        }
        if(nums[0] == nums[1]){
            for(int i=1; i < nums.length-1; i++){
                if(nums[i] < nums[i+1]){
                    if(large == 1){
                        return false;
                    }
                    small = 1;
                }else if(nums[i] > nums[i+1]){
                    if(small == 1){
                        return false;
                    }
                    large = 1;
                }
            }
        }
        return true;
    }
}
