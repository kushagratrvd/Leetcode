class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        permutations(arr, 0, nums);
        return arr;
    }

    public void permutations(List<List<Integer>> arr, int ind, int[] nums) {
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            arr.add(new ArrayList<>(ds));
        }
        for(int start = ind; start < nums.length; start++){
            swap(ind, nums, start);
            permutations(arr, ind+1, nums);
            swap(ind, nums, start);           
        }
    }

    public void swap(int ind, int[] nums, int start) {
        int temp = nums[start];
        nums[start] = nums[ind];
        nums[ind] = temp;
    }
}
