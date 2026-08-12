class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 2 && nums[i] <= 0){
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));

    low++;
    high--;

    while (low < high && nums[low] == nums[low - 1]) {
        low++;
    }

    while (low < high && nums[high] == nums[high + 1]) {
        high--;
    }
}
                else if(sum > 0) high--;
                else low++;       
            }
            i++;
            while(i < nums.length && nums[i-1] == nums[i]) i++;
        }
        return ans;
    }
}
