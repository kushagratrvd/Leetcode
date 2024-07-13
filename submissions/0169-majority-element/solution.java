class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;
        //int max = 0;
        if(nums.length>1){
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1] ){
                count++;
                if(count > n/2){
                    return nums[i];
                }
            }
            else if(nums[i] != nums[i+1]){
                
                count = 1;
            }
                
            }
        }
        else{
            return nums[0];
        }
        return 0;
    }
}
