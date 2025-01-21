class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int ind=0;
        addSubsets(nums,ind,list,temp);
        return list;
    }
    public void addSubsets(int[] nums,int ind, List<List<Integer>> list, List<Integer> temp) {
        if(ind >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[ind]);
        addSubsets(nums,ind+1,list,temp);
        
        temp.remove(temp.size()-1);
        addSubsets(nums,ind+1,list,temp);
    }
}
