class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsequences(arr, temp, 0, nums);
        return arr;
    }

    public void subsequences(List<List<Integer>> arr, List<Integer> temp, int ind, int[] nums){
        if(ind >= nums.length){
            arr.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[ind]);
        subsequences(arr,temp,ind+1,nums);

        temp.remove(temp.size()-1);
        subsequences(arr,temp,ind+1,nums);
    }
}
