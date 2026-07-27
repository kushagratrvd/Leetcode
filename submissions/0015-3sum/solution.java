class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i < nums.length-2 && nums[i] <= 0; i++){
            
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                int sum = nums[low] + nums[high] + nums[i];
                if(sum > 0) high--;
                else if(sum < 0) low++;
                else{
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                    
                    low++;
                    //if(nums[high] == nums[high-1]){
                        while(low < high && nums[high] == nums[high-1]) high--;
                    //}
                    high--;
                }
            }
            while(nums[i] <= 0 && i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return ans;
    }
}
