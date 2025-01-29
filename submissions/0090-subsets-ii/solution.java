class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Powerset(list,nums,new ArrayList<>(),0);
        return list;
    }
    public void Powerset(List<List<Integer>> list, int[] nums, List<Integer> temp, int i){
        if(i==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        Powerset(list,nums,temp,i+1);
        temp.remove(temp.size()-1);
        int curr = nums[i];
        for(int ind=i; ind<nums.length; ind++){
            if(curr==nums[ind]) i++;
        }
        Powerset(list,nums,temp,i);
    }
}
