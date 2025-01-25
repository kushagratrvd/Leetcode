class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(nums,target,0,new ArrayList<>(),list);
        return list;
    }
    public void subsets(int[] nums, int target, int i,List<Integer> temp ,List<List<Integer>> list) {
        if(i == nums.length) {
            if(target == 0){
            list.add(new ArrayList<>(temp)); 
            }
        return;
        }
 
        if(nums[i] <= target){
            temp.add(nums[i]);
            subsets(nums,target-nums[i],i,temp,list);
            temp.remove(temp.size()-1);
        }
        
        subsets(nums,target,i+1,temp,list);
    }
}
