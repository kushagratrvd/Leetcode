class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        recursion(list,nums,target, 0, new ArrayList<>());
        return list;
    }
    public void recursion(List<List<Integer>> list, int[] nums, int target, int ind, List<Integer> temp){
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind; i<nums.length; i++){
            if(i > ind && nums[i-1]==nums[i]) continue;
            if(nums[i] > target) break;
            temp.add(nums[i]);
            recursion(list,nums,target-nums[i],i+1,temp);
            temp.remove(temp.size()-1);
            //recursion(list,nums,target,i+1,temp);
        }

    }
}
