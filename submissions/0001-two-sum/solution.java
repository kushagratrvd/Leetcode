class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        //int j = nums.length-1;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i],i);
        }
        //Arrays.sort(nums);
        /*while(nums[i] + nums[j] != target){
            if(nums[i] + nums[j] > target){
                j--;
            }
            else if(nums[i] + nums[j] < target){
                i++;
            }
        }*/
        return ans;
    }
}
