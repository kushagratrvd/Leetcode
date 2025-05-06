class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        List<Integer> temp = new ArrayList<>();
        subsets(arr, temp, nums, 0);
        return arr;
    }

    public void subsets(List<List<Integer>> arr, List<Integer> temp, int[] nums, int ind) {
        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            arr.add(new ArrayList<>(temp));
            subsets(arr,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
